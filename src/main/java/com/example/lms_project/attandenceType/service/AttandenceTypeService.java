package com.example.lms_project.attandenceType.service;

import com.example.lms_project.attandenceType.AttandenceTypeDto;

public interface AttandenceTypeService {

    AttandenceTypeDto getAttandenceTypeById(Integer id);
    void createAttandenceType(AttandenceTypeDto attandenceTypeDto);

}
