package com.example.lms_project.course;

import com.example.lms_project.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Optional<Course> findByIdAndDeletedAtIsNull(Integer id);

    List<Course> findAllByDeletedAtIsNull();

}
