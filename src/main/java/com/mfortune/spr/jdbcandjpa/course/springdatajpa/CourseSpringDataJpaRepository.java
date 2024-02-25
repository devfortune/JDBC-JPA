package com.mfortune.spr.jdbcandjpa.course.springdatajpa;

import com.mfortune.spr.jdbcandjpa.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    List<Course> findByAuthor(String author); // My custom method
    List<Course> findByName(String name);
}
