package com.example.lms_project.course;

import javax.validation.constraints.NotBlank;

public class CourseDto {
    private Integer id;
    @NotBlank(message = "Please, enter name of course")
    private String name;
    private Boolean status;
}
