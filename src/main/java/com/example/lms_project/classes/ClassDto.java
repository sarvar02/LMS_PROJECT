package com.example.lms_project.classes;

import com.example.lms_project.room.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ClassDto {
    private Integer id;
    private String name;
    private Room room;
    private Integer roomId;

//     Todo Attandence type
//     Todo User group
}
