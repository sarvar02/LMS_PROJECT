package com.example.lms_project.attandenceType;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AttandenceTypeMapper {

    AttandenceType dtoToModel(AttandenceTypeDto attandenceTypeDto);

    AttandenceTypeDto modelToDto(AttandenceType attandenceType);
}
