package com.example.lms_project.sertificate;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-09T15:34:04+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Ubuntu)"
)
@Component
public class CertificateMapperImpl implements CertificateMapper {

    @Override
    public Certificate dtoToModel(CertificateDto dto) {
        if ( dto == null ) {
            return null;
        }

        Certificate certificate = new Certificate();

        certificate.setId( dto.getId() );
        certificate.setCourseId( dto.getCourseId() );
        certificate.setToken( dto.getToken() );
        certificate.setName( dto.getName() );
        certificate.setSurname( dto.getSurname() );
        certificate.setUrl( dto.getUrl() );
        certificate.setPath( dto.getPath() );
        certificate.setFinishedDate( dto.getFinishedDate() );
        certificate.setCreatedAt( dto.getCreatedAt() );
        certificate.setDeletedAt( dto.getDeletedAt() );

        return certificate;
    }

    @Override
    public CertificateDto modelToDto(Certificate certificate) {
        if ( certificate == null ) {
            return null;
        }

        CertificateDto certificateDto = new CertificateDto();

        certificateDto.setId( certificate.getId() );
        certificateDto.setCourseId( certificate.getCourseId() );
        certificateDto.setToken( certificate.getToken() );
        certificateDto.setName( certificate.getName() );
        certificateDto.setSurname( certificate.getSurname() );
        certificateDto.setUrl( certificate.getUrl() );
        certificateDto.setPath( certificate.getPath() );
        certificateDto.setFinishedDate( certificate.getFinishedDate() );
        certificateDto.setCreatedAt( certificate.getCreatedAt() );
        certificateDto.setDeletedAt( certificate.getDeletedAt() );

        return certificateDto;
    }
}
