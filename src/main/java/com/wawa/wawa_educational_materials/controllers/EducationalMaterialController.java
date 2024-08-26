package com.wawa.wawa_educational_materials.controllers;

import com.wawa.wawa_educational_materials.models.educational_materials.EducationalMaterial;
import com.wawa.wawa_educational_materials.services.EducationalMaterialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class EducationalMaterialController {

    private final EducationalMaterialService educationalMaterialService;

    public EducationalMaterialController(EducationalMaterialService educationalMaterialService) {
        this.educationalMaterialService = educationalMaterialService;
    }

    @GetMapping("/{idCourse}/{idMaterial}")
    public EducationalMaterial getEducationalMaterial(@PathVariable int idCourse, @PathVariable int idMaterial) {
        return educationalMaterialService.getEducationalMaterialById(idCourse, idMaterial);
    }

    @GetMapping("/{id}/materials")
    public List<EducationalMaterial> getAllMaterials(@PathVariable int id) {
        return educationalMaterialService.getAllMaterials(id);
    }

    @GetMapping("/{id}/points")
    public List<EducationalMaterial> getPoints(@PathVariable int id) {
        return educationalMaterialService.getAllPointsMaterial(id);
    }
}
