package com.example.lms_project.sertificate;
import java.util.List;

public interface CertificateService {
    Certificate create(CertificateDto dto);
    byte[] getOne(String token);
    List<CertificateDto> getAll(CertificateDto dto);
    void delete(String token);
}
