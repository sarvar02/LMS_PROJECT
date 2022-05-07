package com.example.lms_project.user.serviceImpl;
import com.example.lms_project.user.*;
import com.example.lms_project.www.exception.ServerBadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    @Override
    public void create(UserDto dto) {
        User user = mapper.dtoToModel(dto);
        user.setCreatedAt(LocalDateTime.now());
        user.setStatus(true);
        userRepository.save(user);
    }

    @Override
    public UserDto getOne(Integer id) {
        return mapper.modelToDto(getEntity(id));
    }

    @Override
    public List<UserDto> getAll() {
        return getAllEntity()
                .stream()
                .map(mapper::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer id, UserDto dto) {
        User old = getEntity(id);
        User user = mapper.dtoToModel(dto);
        user.setCreatedAt(old.getCreatedAt());
        user.setStatus(old.getStatus());
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        User user = getEntity(id);
        user.setDeletedAt(LocalDateTime.now());
        userRepository.save(user);
    }

    // |- SECONDARY FUNCTIONS -|

    public User getEntity(Integer id){
        return userRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(()-> new ServerBadRequestException("User not found!"));
    }

    public List<User> getAllEntity(){
        List<User> users = userRepository.findAllByDeletedAtIsNull();
        if (users.isEmpty()){
            throw new ServerBadRequestException("There is no User!");
        }
        return users;
    }
}
