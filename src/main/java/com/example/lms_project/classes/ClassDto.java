package com.example.lms_project.classes;

import com.example.lms_project.room.Room;
import com.example.lms_project.userGroup.UserGroupDto;
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
    private UserGroupDto userGroupDto;
    private Integer userGroupId;
//     Todo Attandence type
}
