package com.wawa.wawa.service.interfaces;

import com.wawa.wawa.entity.Course;

import java.util.List;

public interface CourseService {

    Course getCourseById(int id);

    List<Course> getAllCourses();

    Course addCourse(Course course);

    void deleteCourse(int id);
}
