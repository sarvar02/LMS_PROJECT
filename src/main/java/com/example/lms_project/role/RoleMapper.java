package com.example.lms_project.role;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto modelToDto(Role role);
    Role dtoToModel(RoleDto roleDto);
}
