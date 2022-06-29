package com.example.lms_project.classes;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T17:23:16+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
)
@Component
public class ClassMapperImpl implements ClassMapper {

    @Override
    public Class dtoToModel(ClassDto classDto) {
        if ( classDto == null ) {
            return null;
        }

        Class class1 = new Class();

        class1.setId( classDto.getId() );
        class1.setName( classDto.getName() );
        class1.setRoom( classDto.getRoom() );
        class1.setRoomId( classDto.getRoomId() );
        class1.setUserGroupId( classDto.getUserGroupId() );

        return class1;
    }

    @Override
    public ClassDto modelToDto(Class clas) {
        if ( clas == null ) {
            return null;
        }

        ClassDto classDto = new ClassDto();

        classDto.setId( clas.getId() );
        classDto.setName( clas.getName() );
        classDto.setRoom( clas.getRoom() );
        classDto.setRoomId( clas.getRoomId() );
        classDto.setUserGroupId( clas.getUserGroupId() );

        return classDto;
    }
}
