package com.example.lms_project.course.service;

import com.example.lms_project.course.CourseDto;

import java.util.List;

public interface CourseService {
    CourseDto getCourseById(Integer id);
    void createCourse(CourseDto courseDto);
    void updateCourse(Integer id, CourseDto courseDto);
    void deleteCourse(Integer id);
    List<CourseDto> getAllCourses();
}