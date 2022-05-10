package com.example.lms_project.userGroup;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserGroupMapper {

    UserGroup dtoToModel(UserGroupDto userGroupDto);

    UserGroupDto modelToDto(UserGroup userGroup);
}
