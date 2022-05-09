package com.example.lms_project.group;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-09T09:23:35+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
)
@Component
public class GroupMapperImpl implements GroupMapper {

    @Override
    public Group dtoToModel(GroupDto groupDto) {
        if ( groupDto == null ) {
            return null;
        }

        Group group = new Group();

        group.setId( groupDto.getId() );
        group.setCourseId( groupDto.getCourseId() );
        group.setGroupTypeId( groupDto.getGroupTypeId() );
        group.setName( groupDto.getName() );

        return group;
    }

    @Override
    public GroupDto modelToDto(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDto groupDto = new GroupDto();

        groupDto.setId( group.getId() );
        groupDto.setCourseId( group.getCourseId() );
        groupDto.setGroupTypeId( group.getGroupTypeId() );
        groupDto.setName( group.getName() );

        return groupDto;
    }
}
