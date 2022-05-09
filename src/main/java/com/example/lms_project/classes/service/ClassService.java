package com.example.lms_project.classes.service;

import com.example.lms_project.classes.Class;
import com.example.lms_project.classes.ClassDto;

import java.util.List;

public interface ClassService {
    ClassDto getClassById(Integer id);
    void createClass(ClassDto classDto);
    void updateCLass(Integer id, ClassDto classDto);
    void deleteClass(Integer id);
    List<ClassDto> getAllClasses();
}
