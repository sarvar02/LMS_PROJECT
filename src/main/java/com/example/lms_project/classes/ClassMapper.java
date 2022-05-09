package com.example.lms_project.classes;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ClassMapper {

    Class dtoToModel(ClassDto classDto);

    ClassDto modelToDto(Class clas);
}
