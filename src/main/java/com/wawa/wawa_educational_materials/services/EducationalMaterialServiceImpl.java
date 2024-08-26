package com.wawa.wawa_educational_materials.services;

import com.wawa.wawa_educational_materials.entities.Course;
import com.wawa.wawa_educational_materials.models.AdapterMaterial;
import com.wawa.wawa_educational_materials.models.educational_materials.EducationalMaterial;
import com.wawa.wawa_educational_materials.models.educational_materials.PointMaterial;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class EducationalMaterialServiceImpl implements EducationalMaterialService {

    private final AdapterMaterial adapterMaterial = new AdapterMaterial();

    @Override
    public EducationalMaterial getEducationalMaterialById(int idCourse, int idEducationalMaterial) {
        return adapterMaterial.createEducationalMaterial(idCourse, idEducationalMaterial);
    }

    @Override
    public List<EducationalMaterial> getAllMaterials(int idCourse) {

        List<EducationalMaterial> materials = new ArrayList<>();
        String materialsPath = EducationalMaterial.getDirectory() + File.separator + idCourse + "/materials";
        File materialsFile = new File(materialsPath);

        if (materialsFile.isDirectory()) {
            File[] materialsFiles = materialsFile.listFiles();
            for(int i = 0; i < (materialsFiles != null ? materialsFiles.length : 0); i++) {
                int idMaterial = i +1;
                materials.add(adapterMaterial.createEducationalMaterial(idCourse,idMaterial));
            }
            return materials;
        }
        return null;
    }

    @Override
    public List<EducationalMaterial> getAllPointsMaterial(int idCourse) {

        List<EducationalMaterial> materials = new ArrayList<>();
        String materialsPath = EducationalMaterial.getDirectory() + File.separator + idCourse + "/materials";
        File materialsFile = new File(materialsPath);

        if (materialsFile.isDirectory()) {
            File[] materialsFiles = materialsFile.listFiles();
            for(int i = 0; i < (materialsFiles != null ? materialsFiles.length : 0); i++) {
                int idMaterial = i +1;
                materials.add(new PointMaterial(i+1,EducationalMaterial.getRoute(idCourse,idMaterial)));
            }
            return materials;
        }
        return null;
    }

    @Override
    public String createCourseDirectory(String idCourse) {
        File fileCourse = new File(EducationalMaterial.getDirectory()
                + File.separator + idCourse + File.separator + "materials");
        if (!fileCourse.exists()) {
            if (fileCourse.mkdirs()){
                return fileCourse.getPath();
            }
        }
        return null;
    }

    @SneakyThrows
    @Override
    public void createEducationalMaterial(Course course) {
        String coursePath = createCourseDirectory(course.getId());
        if (coursePath != null){
            StringBuilder comprobate = new StringBuilder();
            for (int i = 1; i <= course.getCantMaterials(); i++){
                File material = new File(coursePath + File.separator + i + ".txt");
                if(material.createNewFile()){
                    comprobate.append(i).append(" creado ");
                }
            }
            System.out.println(comprobate);
        }
    }
}
