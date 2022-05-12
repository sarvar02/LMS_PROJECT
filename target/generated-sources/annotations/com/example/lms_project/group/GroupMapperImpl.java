package com.example.lms_project.group;

import com.example.lms_project.course.Course;
import com.example.lms_project.course.CourseDto;
import com.example.lms_project.groupType.GroupType;
import com.example.lms_project.groupType.GroupTypeDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T17:21:36+0500",
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
        group.setCourse( courseDtoToCourse( groupDto.getCourse() ) );
        group.setCourseId( groupDto.getCourseId() );
        group.setGroupType( groupTypeDtoToGroupType( groupDto.getGroupType() ) );
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
        groupDto.setCourse( courseToCourseDto( group.getCourse() ) );
        groupDto.setCourseId( group.getCourseId() );
        groupDto.setGroupType( groupTypeToGroupTypeDto( group.getGroupType() ) );
        groupDto.setGroupTypeId( group.getGroupTypeId() );
        groupDto.setName( group.getName() );

        return groupDto;
    }

    protected Course courseDtoToCourse(CourseDto courseDto) {
        if ( courseDto == null ) {
            return null;
        }

        Course course = new Course();

        course.setId( courseDto.getId() );
        course.setName( courseDto.getName() );
        course.setStatus( courseDto.getStatus() );

        return course;
    }

    protected GroupType groupTypeDtoToGroupType(GroupTypeDto groupTypeDto) {
        if ( groupTypeDto == null ) {
            return null;
        }

        GroupType groupType = new GroupType();

        groupType.setId( groupTypeDto.getId() );
        groupType.setName( groupTypeDto.getName() );

        return groupType;
    }

    protected CourseDto courseToCourseDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setId( course.getId() );
        courseDto.setName( course.getName() );
        courseDto.setStatus( course.getStatus() );

        return courseDto;
    }

    protected GroupTypeDto groupTypeToGroupTypeDto(GroupType groupType) {
        if ( groupType == null ) {
            return null;
        }

        GroupTypeDto groupTypeDto = new GroupTypeDto();

        groupTypeDto.setId( groupType.getId() );
        groupTypeDto.setName( groupType.getName() );

        return groupTypeDto;
    }
}
