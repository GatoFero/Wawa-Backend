package com.wawa.wawa_educational_materials.services;

import com.wawa.wawa_educational_materials.entities.Course;
import com.wawa.wawa_educational_materials.models.educational_materials.EducationalMaterial;

import java.util.List;

public interface EducationalMaterialService {

    EducationalMaterial getEducationalMaterialById(int idCourse, int idEducationalMaterial);

    List<EducationalMaterial> getAllMaterials(int idCourse);

    List<EducationalMaterial> getAllPointsMaterial(int idCourse);

    String createCourseDirectory(String idCourse);

    void createEducationalMaterial(Course course);
}
