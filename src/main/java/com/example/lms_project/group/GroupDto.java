package com.example.lms_project.group;

import com.example.lms_project.course.Course;
import com.example.lms_project.course.CourseDto;
import com.example.lms_project.groupType.GroupType;
import com.example.lms_project.groupType.GroupTypeDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class GroupDto {
    private Integer id;
    private CourseDto course;
    @NotNull(message = "course id cannot bu null")
    private Integer courseId;
    private GroupTypeDto groupType;
    @NotNull(message = "group type id cannot bu null")
    private Integer groupTypeId;
    @NotBlank(message = "name of group cannot be blank")
    private String name;
}
