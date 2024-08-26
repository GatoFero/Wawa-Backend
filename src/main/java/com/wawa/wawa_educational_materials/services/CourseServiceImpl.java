package com.wawa.wawa_educational_materials.services;

import com.wawa.wawa_educational_materials.entities.Course;
import com.wawa.wawa_educational_materials.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final EducationalMaterialService educationalMaterialService;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, EducationalMaterialService educationalMaterialService) {
        this.courseRepository = courseRepository;
        this.educationalMaterialService = educationalMaterialService;
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
        if (course.getCantMaterials() != null){
            educationalMaterialService.createEducationalMaterial(course);
        }
    }


    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourse(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
