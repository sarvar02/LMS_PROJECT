package com.example.lms_project.user;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-07T04:44:58+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Ubuntu)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto modelToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setRole( user.getRole() );
        userDto.setRoleId( user.getRoleId() );
        userDto.setFirstname( user.getFirstname() );
        userDto.setLastname( user.getLastname() );
        userDto.setUsername( user.getUsername() );
        userDto.setPhone( user.getPhone() );
        userDto.setPassword( user.getPassword() );

        return userDto;
    }

    @Override
    public User dtoToModel(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setRole( dto.getRole() );
        user.setRoleId( dto.getRoleId() );
        user.setFirstname( dto.getFirstname() );
        user.setLastname( dto.getLastname() );
        user.setUsername( dto.getUsername() );
        user.setPhone( dto.getPhone() );
        user.setPassword( dto.getPassword() );

        return user;
    }
}
