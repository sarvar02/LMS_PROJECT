package com.example.lms_project.groupType.service;

import com.example.lms_project.exception.ServerBadRequestException;
import com.example.lms_project.groupType.GroupType;
import com.example.lms_project.groupType.GroupTypeDto;
import com.example.lms_project.groupType.GroupTypeMapper;
import com.example.lms_project.groupType.GroupTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupTypeServiceImpl implements GroupTypeService{

    private final GroupTypeRepository groupTypeRepository;
    private final GroupTypeMapper groupTypeMapper;

    public GroupTypeServiceImpl(GroupTypeRepository groupTypeRepository, GroupTypeMapper groupTypeMapper) {
        this.groupTypeRepository = groupTypeRepository;
        this.groupTypeMapper = groupTypeMapper;
    }

    @Override
    public GroupTypeDto getGroupTypeById(Integer id) {
        GroupType groupType = getEntity(id);
        return groupTypeMapper.modelToDto(groupType);
    }

    @Override
    public void createGroupType(GroupTypeDto groupTypeDto) {
        GroupType groupType = groupTypeMapper.dtoToModel(groupTypeDto);
        groupType.setCreatedAt(LocalDateTime.now());
        groupType.setStatus(true);

        saveToDatabase(groupType);
    }

    @Override
    public void updateGroupType(Integer id, GroupTypeDto groupTypeDto) {
        GroupType groupType = getEntity(id);
        GroupType newGroupType = groupTypeMapper.dtoToModel(groupTypeDto);

        newGroupType.setId(id);
        newGroupType.setCreatedAt(groupType.getCreatedAt());
        newGroupType.setStatus(groupType.getStatus());
        newGroupType.setUpdatedAt(LocalDateTime.now());

        saveToDatabase(newGroupType);
    }

    @Override
    public void deleteGroupType(Integer id) {
        GroupType groupType = getEntity(id);
        groupType.setDeletedAt(LocalDateTime.now());

        saveToDatabase(groupType);
    }

    @Override
    public List<GroupTypeDto> getAllGroupTypes() {
        List<GroupType> groupTypeList = groupTypeRepository.findAllByDeletedAtIsNull();
        if(groupTypeList.isEmpty())
            throw new ServerBadRequestException("Group type not found !");

        return groupTypeList.stream()
                .map(groupTypeMapper::modelToDto)
                .collect(Collectors.toList());
    }


//   | <- Secondary function -> |

    public GroupType getEntity(Integer id){
        return groupTypeRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ServerBadRequestException("Group type not found !"));
    }

    @Transactional
    public void saveToDatabase(GroupType groupType){
        groupTypeRepository.save(groupType);
    }
}
