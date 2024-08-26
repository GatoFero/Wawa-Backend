package com.wawa.wawa_educational_materials.controllers;

import com.wawa.wawa_educational_materials.entities.Course;
import com.wawa.wawa_educational_materials.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wawa/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseEntity.ok().body(course);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable String id) {
        return ResponseEntity.ok().body(courseService.getCourse(id));
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllCourses() {
        return ResponseEntity.ok().body(courseService.getCourses());
    }
}
