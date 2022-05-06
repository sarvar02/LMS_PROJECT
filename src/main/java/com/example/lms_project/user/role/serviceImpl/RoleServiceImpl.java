package com.example.lms_project.user.role.serviceImpl;

import com.example.lms_project.exception.ServerBadRequestException;
import com.example.lms_project.user.role.Role;
import com.example.lms_project.user.role.RoleDto;
import com.example.lms_project.user.role.RoleRepository;
import com.example.lms_project.user.role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public void create(RoleDto dto) {

    }

    @Override
    public RoleDto getOne(Integer id) {
        return null;
    }

    @Override
    public List<RoleDto> getAll() {
        return null;
    }

    @Override
    public void update(Integer id, RoleDto dto) {

    }

    @Override
    public void delete(Integer id) {

    }

    // |- SECONDARY FUNCTIONS -|

    public Role getEntity(Integer id){
        return roleRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ServerBadRequestException("Role not found!"));
    }

    public List<Role> getAllEntity(){
        List<Role> roles = roleRepository.findAllByDeletedAtIsNull();
        if (roles.isEmpty()) {
            throw new ServerBadRequestException("There is no Roles");
        }
        return roles;
    }
}
