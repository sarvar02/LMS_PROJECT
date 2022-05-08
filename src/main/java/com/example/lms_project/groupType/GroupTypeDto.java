package com.example.lms_project.groupType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class GroupTypeDto {
    private Integer id;
    @NotBlank(message = "name cannot be blank")
    private String name;
}
