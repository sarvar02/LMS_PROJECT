package com.example.lms_project.groupType;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface GroupTypeMapper {

    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    GroupType dtoToModel(GroupTypeDto groupTypeDto);

    GroupTypeDto modelToDto(GroupType groupType);
}
