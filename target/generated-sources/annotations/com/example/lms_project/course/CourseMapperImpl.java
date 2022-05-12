package com.example.lms_project.course;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T17:21:36+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public Course dtoToModel(CourseDto courseDto) {
        if ( courseDto == null ) {
            return null;
        }

        Course course = new Course();

        course.setId( courseDto.getId() );
        course.setName( courseDto.getName() );

        return course;
    }

    @Override
    public CourseDto modelToDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setId( course.getId() );
        courseDto.setName( course.getName() );
        courseDto.setStatus( course.getStatus() );

        return courseDto;
    }
}
