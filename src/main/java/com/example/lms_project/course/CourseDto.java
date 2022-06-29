package com.example.lms_project.course;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CourseDto {
    private Integer id;
    @NotBlank(message = "Please, enter name of course")
    private String name;
    private Boolean status;
}
