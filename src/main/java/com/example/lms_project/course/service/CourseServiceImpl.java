package com.example.lms_project.course.service;

import com.example.lms_project.course.Course;
import com.example.lms_project.course.CourseDto;
import com.example.lms_project.course.CourseMapper;
import com.example.lms_project.course.CourseRepository;
import com.example.lms_project.exception.ServerBadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseDto getCourseById(Integer id) {
        Course course = getEntity(id);
        return courseMapper.modelToDto(course);
    }

    @Override
    public void createCourse(CourseDto courseDto) {
        Course course = courseMapper.dtoToModel(courseDto);
        course.setCreatedAt(LocalDateTime.now());
        course.setStatus(true);

        saveToDatabase(course);
    }

    @Override
    public void updateCourse(Integer id, CourseDto courseDto) {
        Course course = getEntity(id);
        Course newCourse = courseMapper.dtoToModel(courseDto);

        newCourse.setId(id);
        newCourse.setStatus(course.getStatus());
        newCourse.setCreatedAt(course.getCreatedAt());
        newCourse.setUpdatedAt(LocalDateTime.now());

        saveToDatabase(newCourse);
    }

    @Override
    public void deleteCourse(Integer id) {
        Course course = getEntity(id);
        course.setDeletedAt(LocalDateTime.now());
        saveToDatabase(course);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courseList = courseRepository.findAllByDeletedAtIsNull();
        if(courseList.isEmpty())
            throw new ServerBadRequestException("Course not found !");

        return courseList
                .stream()
                .map(courseMapper::modelToDto)
                .collect(Collectors.toList());
    }


    // Secondary functions

    public Course getEntity(Integer id){
        return courseRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ServerBadRequestException("Course not found !"));
    }

    @Transactional
    public void saveToDatabase(Course course){
        courseRepository.save(course);
    }
}
