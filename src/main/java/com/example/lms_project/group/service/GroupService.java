package com.example.lms_project.group.service;
import com.example.lms_project.group.GroupDto;

import java.util.List;


public interface GroupService {
    GroupDto getGroupById(Integer id);
    void createGroup(GroupDto groupDto);
    void updateGroup(Integer id, GroupDto groupDto);
    void deleteGroup(Integer id);
    List<GroupDto> getAllGroups();
}
