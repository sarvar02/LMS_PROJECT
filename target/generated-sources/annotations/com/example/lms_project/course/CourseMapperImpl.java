package com.example.lms_project.course;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-07T06:20:23+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Ubuntu)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public Course dtoToModel(CourseDto courseDto) {
        if ( courseDto == null ) {
            return null;
        }

        Course course = new Course();

        return course;
    }

    @Override
    public CourseDto modelToDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        return courseDto;
    }
}
