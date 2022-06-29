package com.example.lms_project.sertificate;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T17:21:36+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
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
        if ( dto.getCourseId() != null ) {
            certificate.setCourseId( dto.getCourseId().intValue() );
        }
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
        if ( certificate.getCourseId() != null ) {
            certificateDto.setCourseId( certificate.getCourseId().longValue() );
        }
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
