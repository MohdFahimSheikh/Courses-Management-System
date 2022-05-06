package com.epam.coursesapi.services;

import com.epam.coursesapi.entity.Course;

import java.util.List;


public interface CourseService {
    public List<Course> getAllCourses();

   public Course getCourseById(long id);

   public Course addCourse(Course course);

   public Course updateCourse(Course course,long id);

   public void deleteCourse(Long courseId);
}
