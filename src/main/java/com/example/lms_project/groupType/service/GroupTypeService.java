package com.example.lms_project.groupType.service;

import com.example.lms_project.groupType.GroupTypeDto;

import java.util.List;

public interface GroupTypeService {
    GroupTypeDto getGroupTypeById(Integer id);
    void createGroupType(GroupTypeDto groupTypeDto);
    void updateGroupType(Integer id, GroupTypeDto groupTypeDto);
    void deleteGroupType(Integer id);
    List<GroupTypeDto> getAllGroupTypes();
}
