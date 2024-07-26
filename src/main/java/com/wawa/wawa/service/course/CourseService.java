package com.wawa.wawa.service.course;

import com.wawa.wawa.entity.Course;
import java.util.List;

public interface CourseService {
    Course getCourseById(int id);
    Course getCourseByName(String name);
    Course addCourse(Course course);
    Course updateCourse(Course course);
    List<Course> getAllCourses();
}
