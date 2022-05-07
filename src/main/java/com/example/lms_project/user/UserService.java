package com.example.lms_project.user;

import com.example.lms_project.user.UserDto;

import java.util.List;

public interface UserService {

    void create(UserDto dto);

    UserDto getOne(Integer id);

    List<UserDto> getAll();

    void update(Integer id, UserDto dto);

    void delete(Integer id);
}
