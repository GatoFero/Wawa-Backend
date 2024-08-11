package com.wawa.wawa.controller;

import com.wawa.wawa.entity.Course;
import com.wawa.wawa.models.AdapterMaterial;
import com.wawa.wawa.models.EducationalMaterial;
import com.wawa.wawa.models.Theme;
import com.wawa.wawa.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //Get courses and read themes
    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
    @GetMapping("/{id}")
    public Course getCourse(@PathVariable int id) {
        return courseService.getCourseById(id);
    }
    @GetMapping("/themes/{idCourse}/{idTheme}")
    public EducationalMaterial getTheme(@PathVariable int idCourse, @PathVariable int idTheme) {
        AdapterMaterial adapterMaterial =new AdapterMaterial();
        adapterMaterial.createMaterial(idCourse, idTheme);
        return adapterMaterial.getEducationalMaterial();
    }
    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }


    @PostMapping("/delete/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }
}
