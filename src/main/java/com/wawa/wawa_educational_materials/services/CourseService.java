package com.wawa.wawa_educational_materials.services;

import com.wawa.wawa_educational_materials.entities.Course;

import java.util.List;

public interface CourseService {

    void addCourse(Course course);
    List<Course> getCourses();
    Course getCourse(String id);
    void updateCourse(Course course);
    void deleteCourse(String id);
}
