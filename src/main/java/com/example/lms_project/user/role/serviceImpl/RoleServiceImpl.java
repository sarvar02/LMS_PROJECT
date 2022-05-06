package com.example.lms_project.user.role.serviceImpl;
import com.example.lms_project.exception.ServerBadRequestException;
import com.example.lms_project.user.role.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper mapper;
    @Override
    public void create(RoleDto dto) {
        Role role = mapper.dtoToModel(dto);
        role.setCreatedAt(LocalDateTime.now());
        role.setStatus(true);
        roleRepository.save(role);
    }

    @Override
    public RoleDto getOne(Integer id) {
        return mapper.modelToDto(getEntity(id));
    }

    @Override
    public List<RoleDto> getAll() {
        return getAllEntity()
                .stream()
                .map(mapper::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer id, RoleDto dto) {
        Role old = getEntity(id);
        Role role = mapper.dtoToModel(dto);
        old.setName(role.getName());
        old.setUpdatedAt(LocalDateTime.now());
        roleRepository.save(old);
    }

    @Override
    public void delete(Integer id) {
        Role role = getEntity(id);
        role.setDeletedAt(LocalDateTime.now());
        roleRepository.save(role);
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
