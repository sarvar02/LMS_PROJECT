package com.example.lms_project.userGroup;

import com.example.lms_project.group.Group;
import com.example.lms_project.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class UserGroupDto {
    private Integer id;
    private Group group;
    private Integer groupId;
    private User user;
    private Integer userId;
}
