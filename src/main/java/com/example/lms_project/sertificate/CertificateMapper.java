package com.example.lms_project.sertificate;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CertificateMapper {

    Certificate dtoToModel(CertificateDto dto);

    CertificateDto modelToDto(Certificate certificate);
}
