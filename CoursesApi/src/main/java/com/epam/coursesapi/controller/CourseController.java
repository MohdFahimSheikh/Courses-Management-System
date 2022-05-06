package com.epam.coursesapi.controller;

import com.epam.coursesapi.entity.Course;
import com.epam.coursesapi.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getAllCourses();
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable("courseId") long courseId) {

        return new ResponseEntity<Course>(this.courseService.getCourseById(courseId), HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return new ResponseEntity<Course>(this.courseService.addCourse(course), HttpStatus.OK);
    }

    @PutMapping("/courses/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable("courseId") long courseId, @RequestBody Course course) {
        return new ResponseEntity<Course>(this.courseService.updateCourse(course, courseId), HttpStatus.OK);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("courseId") long courseId) {
        try {
            this.courseService.deleteCourse(courseId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

