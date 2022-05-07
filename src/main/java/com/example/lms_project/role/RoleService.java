package com.example.lms_project.role;
import java.util.List;

public interface RoleService {

    //create
    void create(RoleDto dto);
    //read
    RoleDto getOne(Integer id);
    List<RoleDto> getAll();
    //update
    void update(Integer id, RoleDto dto);
    //delete
    void delete(Integer id);
}
