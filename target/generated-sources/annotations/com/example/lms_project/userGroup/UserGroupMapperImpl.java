package com.example.lms_project.userGroup;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T17:23:16+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
)
@Component
public class UserGroupMapperImpl implements UserGroupMapper {

    @Override
    public UserGroup dtoToModel(UserGroupDto userGroupDto) {
        if ( userGroupDto == null ) {
            return null;
        }

        UserGroup userGroup = new UserGroup();

        userGroup.setId( userGroupDto.getId() );
        userGroup.setGroupId( userGroupDto.getGroupId() );
        userGroup.setUser( userGroupDto.getUser() );
        userGroup.setUserId( userGroupDto.getUserId() );

        return userGroup;
    }

    @Override
    public UserGroupDto modelToDto(UserGroup userGroup) {
        if ( userGroup == null ) {
            return null;
        }

        UserGroupDto userGroupDto = new UserGroupDto();

        userGroupDto.setId( userGroup.getId() );
        userGroupDto.setGroupId( userGroup.getGroupId() );
        userGroupDto.setUser( userGroup.getUser() );
        userGroupDto.setUserId( userGroup.getUserId() );

        return userGroupDto;
    }
}
