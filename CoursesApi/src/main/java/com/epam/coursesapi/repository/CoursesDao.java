package com.epam.coursesapi.repository;


import com.epam.coursesapi.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesDao extends JpaRepository<Course,Long> {

}
