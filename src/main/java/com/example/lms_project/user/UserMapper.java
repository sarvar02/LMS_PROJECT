package com.example.lms_project.user;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto modelToDto(User user);
    User dtoToModel(UserDto dto);
}
