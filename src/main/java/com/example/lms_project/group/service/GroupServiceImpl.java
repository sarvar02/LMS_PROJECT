package com.example.lms_project.group.service;

import com.example.lms_project.course.CourseRepository;
import com.example.lms_project.exception.ServerBadRequestException;
import com.example.lms_project.group.Group;
import com.example.lms_project.group.GroupDto;
import com.example.lms_project.group.GroupMapper;
import com.example.lms_project.group.GroupRepository;
import com.example.lms_project.groupType.GroupTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService{

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final GroupTypeRepository groupTypeRepository;
    private final CourseRepository courseRepository;

    public GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper, GroupTypeRepository groupTypeRepository, CourseRepository courseRepository) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
        this.groupTypeRepository = groupTypeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public GroupDto getGroupById(Integer id) {
        Group group = getEntity(id);
        return groupMapper.modelToDto(group);
    }

    @Override
    public void createGroup(GroupDto groupDto) {

//         Checking...
        checkForUnique(groupDto);

        Group group = groupMapper.dtoToModel(groupDto);
        group.setCreatedAt(LocalDateTime.now());
        group.setStatus(true);
        saveToDatabase(group);
    }

    @Override
    public void updateGroup(Integer id, GroupDto groupDto) {

//      Checking...
        checkForUnique(groupDto);

        Group group = getEntity(id);
        Group newGroup = groupMapper.dtoToModel(groupDto);

        newGroup.setId(id);
        newGroup.setCreatedAt(group.getCreatedAt());
        newGroup.setStatus(group.getStatus());
        newGroup.setUpdatedAt(LocalDateTime.now());

       saveToDatabase(newGroup);
    }

    @Override
    public void deleteGroup(Integer id) {
        Group group = getEntity(id);
        group.setDeletedAt(LocalDateTime.now());
        saveToDatabase(group);
    }

    @Override
    public List<GroupDto> getAllGroups() {
        List<Group> groupList = groupRepository.findAllByDeletedAtIsNull();
        if(groupList.isEmpty()){
            throw new ServerBadRequestException(("Group not found !"));
        }
        return groupList.stream()
                .map(groupMapper::modelToDto)
                .collect(Collectors.toList());
    }


    //   | <- Secondary function -> |

    public Group getEntity(Integer id){
        return groupRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ServerBadRequestException("Group not found !"));
    }

    @Transactional
    public void saveToDatabase(Group group){
        groupRepository.save(group);
    }

    public void checkForUnique(GroupDto groupDto){
        if(!groupTypeRepository.existsById(groupDto.getGroupTypeId())){
            throw new ServerBadRequestException(("Group type not found !"));
        }
        if(!courseRepository.existsById(groupDto.getCourseId())){
            throw new ServerBadRequestException(("Course not found !"));
        }
    }
}
