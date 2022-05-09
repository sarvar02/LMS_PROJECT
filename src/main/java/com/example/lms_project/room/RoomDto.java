package com.example.lms_project.room;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class RoomDto {
    private Integer id;
    private String name;
}
