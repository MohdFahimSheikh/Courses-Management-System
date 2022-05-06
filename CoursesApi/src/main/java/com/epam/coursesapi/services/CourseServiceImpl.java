package com.epam.coursesapi.services;

import com.epam.coursesapi.exception.ResourceNotFoundException;
import com.epam.coursesapi.entity.Course;
import com.epam.coursesapi.repository.CoursesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CoursesDao coursesDao;

    @Override
    public List<Course> getAllCourses() {
        return coursesDao.findAll();
    }

    @Override
    public Course getCourseById(long id) {
        //Optional<Course> course = coursesDao.findById(id);
//        if(course.isPresent()){
//          return course.get();
//        }
//      else{
//          throw new ResourceNotFoundException("Course","Id",id);
//        }
        return coursesDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Course","Id",id));
    }

    @Override
    public Course addCourse(Course course) {
        return coursesDao.save(course);
    }

    @Override
    public Course updateCourse(Course course,long courseId) {
        Course existingCourse=coursesDao.findById(courseId).orElseThrow(()->new ResourceNotFoundException("Course","Id",courseId));
       existingCourse.setId(course.getId());
       existingCourse.setTitle(course.getTitle());
       existingCourse.setDescription(course.getDescription());
        return coursesDao.save(existingCourse);
    }

    @Override
    public void deleteCourse(Long courseId) {
    coursesDao.deleteById(courseId);
    }
}
