package com.example.lms_project.attandenceType;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T14:55:15+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
)
@Component
public class AttandenceTypeMapperImpl implements AttandenceTypeMapper {

    @Override
    public AttandenceType dtoToModel(AttandenceTypeDto attandenceTypeDto) {
        if ( attandenceTypeDto == null ) {
            return null;
        }

        AttandenceType attandenceType = new AttandenceType();

        return attandenceType;
    }

    @Override
    public AttandenceTypeDto modelToDto(AttandenceType attandenceType) {
        if ( attandenceType == null ) {
            return null;
        }

        AttandenceTypeDto attandenceTypeDto = new AttandenceTypeDto();

        return attandenceTypeDto;
    }
}
