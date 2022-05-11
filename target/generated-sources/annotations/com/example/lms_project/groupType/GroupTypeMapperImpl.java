package com.example.lms_project.groupType;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-09T11:38:21+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Ubuntu)"
)
@Component
public class GroupTypeMapperImpl implements GroupTypeMapper {

    @Override
    public GroupType dtoToModel(GroupTypeDto groupTypeDto) {
        if ( groupTypeDto == null ) {
            return null;
        }

        GroupType groupType = new GroupType();

        groupType.setId( groupTypeDto.getId() );
        groupType.setName( groupTypeDto.getName() );

        return groupType;
    }

    @Override
    public GroupTypeDto modelToDto(GroupType groupType) {
        if ( groupType == null ) {
            return null;
        }

        GroupTypeDto groupTypeDto = new GroupTypeDto();

        groupTypeDto.setId( groupType.getId() );
        groupTypeDto.setName( groupType.getName() );

        return groupTypeDto;
    }
}
