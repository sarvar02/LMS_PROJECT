package com.example.lms_project.userGroup.service;

import com.example.lms_project.exception.ServerBadRequestException;
import com.example.lms_project.room.Room;
import com.example.lms_project.userGroup.UserGroup;
import com.example.lms_project.userGroup.UserGroupDto;
import com.example.lms_project.userGroup.UserGroupMapper;
import com.example.lms_project.userGroup.UserGroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserGroupServiceImpl implements UserGroupService{

    private final UserGroupRepository userGroupRepository;
    private final UserGroupMapper userGroupMapper;

    public UserGroupServiceImpl(UserGroupRepository userGroupRepository, UserGroupMapper userGroupMapper) {
        this.userGroupRepository = userGroupRepository;
        this.userGroupMapper = userGroupMapper;
    }

    @Override
    public UserGroupDto getUserGroupById(Integer id) {
        UserGroup userGroup = getEntity(id);
        return userGroupMapper.modelToDto(userGroup);
    }

    @Override
    public void createUserGroup(UserGroupDto userGroupDto) {
        UserGroup userGroup = userGroupMapper.dtoToModel(userGroupDto);
        userGroup.setCreatedAt(LocalDateTime.now());
        userGroup.setStatus(true);

        saveToDatabase(userGroup);
    }

    @Override
    public void updateUserGroup(Integer id, UserGroupDto userGroupDto) {
        UserGroup userGroup = getEntity(id);
        UserGroup newUserGroup = userGroupMapper.dtoToModel(userGroupDto);

        newUserGroup.setId(id);
        newUserGroup.setCreatedAt(userGroup.getCreatedAt());
        newUserGroup.setStatus(userGroup.getStatus());
        newUserGroup.setUpdatedAt(LocalDateTime.now());

        saveToDatabase(newUserGroup);
    }

    @Override
    public void deleteUserGroup(Integer id) {
        UserGroup userGroup = getEntity(id);
        userGroup.setDeletedAt(LocalDateTime.now());
        saveToDatabase(userGroup);
    }

    @Override
    public List<UserGroupDto> getAllUserGroups() {
        List<UserGroup> userGroupList = userGroupRepository.findAllByDeletedAtIsNull();
        if(userGroupList.isEmpty())
            throw new ServerBadRequestException("User group not found !");

        return userGroupList.stream()
                .map(userGroupMapper::modelToDto)
                .collect(Collectors.toList());
    }

    //       | <- Secondary function -> |
    public UserGroup getEntity(Integer id){
        return userGroupRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ServerBadRequestException("Room not found !"));
    }

    @Transactional
    public void saveToDatabase(UserGroup userGroup){
        userGroupRepository.save(userGroup);
    }




//    public List<UserGroupDto> getAllUsersById(Integer userId){
//        List<UserGroup> userGroupList = userGroupRepository.findAllByUserIdAAndDeletedAtIsNull(userId);
//        if(userGroupList.isEmpty())
//            throw new ServerBadRequestException("User not found !");
//        return userGroupList.stream()
//                .map(userGroupMapper::modelToDto)
//                .collect(Collectors.toList());
//    }


}
