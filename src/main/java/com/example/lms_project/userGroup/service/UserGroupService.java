package com.example.lms_project.userGroup.service;

import com.example.lms_project.userGroup.UserGroup;
import com.example.lms_project.userGroup.UserGroupDto;

import java.util.List;

public interface UserGroupService {
    UserGroupDto getUserGroupById(Integer id);
    void createUserGroup(UserGroupDto userGroupDto);
    void updateUserGroup(Integer id, UserGroupDto userGroupDto);
    void deleteUserGroup(Integer id);
    List<UserGroupDto> getAllUserGroups();
}
