package com.example.lms_project.sertificate.serviceImpl;
import com.example.lms_project.course.Course;
import com.example.lms_project.course.CourseRepository;
import com.example.lms_project.exception.ServerBadRequestException;
import com.example.lms_project.sertificate.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.imageio.ImageIO;
import javax.persistence.criteria.Predicate;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {
    private final CertificateRepository certificateRepository;
    private final CourseRepository courseRepository;
    private final CertificateMapper mapper;
    @Value("${certificate.url}")
    private String certificateUrl;
    @Value("${certificate.img.path}")
    private String certificateImgPath;
    @Value("${certificate.director}")
    private String certificateDirector;

    @Override
    public Certificate create(CertificateDto dto) {
        Certificate certificate = mapper.dtoToModel(dto);
        UUID uuid = UUID.randomUUID();
        String url = certificateUrl + "/" + uuid;
        BufferedImage QR = generateQR(url);
        String YMD = getYMD();
        String imagePath = certificateImgPath + YMD + "/" + uuid + ".png";
        File folder = new File(certificateImgPath + YMD);
        if (!folder.exists()){
            folder.mkdirs();
        }
        getImage(QR, certificate, imagePath);
        certificate.setCourse(getCourse(certificate.getCourseId()));
        certificate.setToken(String.valueOf(uuid));
        certificate.setUrl(url);
        certificate.setCreatedAt(LocalDateTime.now());
        certificate.setPath(imagePath);
        certificateRepository.save(certificate);
        return certificate;
    }

    @Override
    public byte[] getOne(String token) {

        try {
            Certificate certificate = getEntity(token);
            String imagePath = certificate.getPath();

            byte[] imageIntByte;
            BufferedImage originalImage;
            try {
                originalImage = ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                return new byte[0];
            }
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            ImageIO.write(originalImage, "png", outputStream);
            outputStream.flush();
            imageIntByte = outputStream.toByteArray();
            outputStream.close();
            return imageIntByte;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public List<CertificateDto> getAll(CertificateDto dto) {
        Integer page = dto.getPage();
        Integer size = dto.getSize();
        String sortBy = dto.getSortBy();


        if (page == null){
            page = 0;
        }
        if (size == null){
            size = 5;
        }
        if (sortBy == null){
            sortBy = "createdAt";
        }



        Pageable paging = PageRequest.of(page, size, dto.getDirectionF(), sortBy);
        List<Predicate> predicates = new LinkedList<>();

        Specification<Certificate> pagedResult = (((root, query, criteriaBuilder) -> {
            if (dto.getName() != null) {
                predicates.add( criteriaBuilder.like(root.get("name"), dto.getName()));
            }
            if (dto.getSurname() != null) {
                predicates.add(criteriaBuilder.like(root.get("lastname"), dto.getSurname()));
            }
            if (dto.getCreatedAt() != null) {
                predicates.add(criteriaBuilder.equal(root.get("phone"), dto.getCreatedAt()));
            }
            return criteriaBuilder.and(predicates.toArray(new javax.persistence.criteria.Predicate[0]));
        }));

        Page<Certificate> certificatePage = certificateRepository.findAll(pagedResult, paging);
        List<CertificateDto> userDtoList = new LinkedList<>();
        for (Certificate certificate : certificatePage) {
            userDtoList.add(mapper.modelToDto(certificate));
        }
        return userDtoList;
    }

    @Override
    public void delete(String token) {
        Certificate certificate = getEntity(token);
        certificate.setDeletedAt(LocalDateTime.now());
        certificateRepository.save(certificate);
    }




    // |- SECONDARY FUNCTIONS -|
    private BufferedImage generateQR(String url) {

        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 350, 350);
            ImageIO.write(MatrixToImageWriter.toBufferedImage(bitMatrix), "png", new File(certificateImgPath + "qr" + ".png"));
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (Exception e) {
            throw new ServerBadRequestException(e.getMessage());
        }
    }

    private String getYMD() {

        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        return String.format("%s/%s/%s", year, month + 1, day);
    }

    private void getImage(BufferedImage qr, Certificate certificate, String imagePath) {

        String road = certificateImgPath + "Template.JPG";
        BufferedImage image;
        try {
            image = ImageIO.read(new File(road));
            Graphics2D graphics2D = image.createGraphics();
            // Here Lastname and Firstname is drawn
            // DrawString(Graphics2D, Color, X, Y, Text, Font);
            String text = certificate.getSurname() + " " + certificate.getName();
            drawString(graphics2D, Color.BLACK, 4425, 3074, text, new Font("Oswald", Font.BOLD, 140));

            // Here Direction is drawn
            // DrawString(Graphics2D, Color, X, Y, Text, Font);
            text = certificate.getCourse().getName();
            drawString(graphics2D, Color.WHITE, 4150, 4350, text, new Font("Oswald", Font.BOLD, 90));

            // Here Director is drawn
            // DrawString(Graphics2D, Color, X, Y, Text, Font);
            text = certificateDirector;
            drawString(graphics2D, Color.BLACK, 6270, 4400, text, new Font("Oswald", Font.BOLD, 60));

            graphics2D.drawImage(qr, 350, 2100, qr.getWidth(), qr.getHeight(), null);
            graphics2D.dispose();

            File file = new File(imagePath);
            ImageIO.write(image, "png", file);
        } catch (Exception e) {
            throw new ServerBadRequestException(e.getMessage());
        }
    }

    private void drawString(Graphics2D graphics2D,Color color, int x, int y, String text, Font font) {
        FontMetrics metrics = graphics2D.getFontMetrics(font);
        int corX = (x - metrics.stringWidth(text)) / 2;
        int corY = (y - metrics.getHeight()) / 2 + metrics.getAscent();
        graphics2D.setFont(font);
        graphics2D.setColor(color);
        graphics2D.drawString(text, corX, corY);
    }

    private Course getCourse(Integer id){
        return courseRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(()-> new ServerBadRequestException("Course not found!"));
    }

    private Certificate getEntity(String token) {
        return certificateRepository.findByTokenAndDeletedAtIsNull(token)
                .orElseThrow(()-> new ServerBadRequestException("Certificate Not found!"));
    }
}
