package com.example.lms_project.group;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface GroupMapper {

    Group dtoToModel(GroupDto groupDto);

    GroupDto modelToDto(Group group);
}
