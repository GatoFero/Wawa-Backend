package com.wawa.wawa_educational_materials.models;

import com.wawa.wawa_educational_materials.models.educational_materials.EducationalMaterial;
import com.wawa.wawa_educational_materials.models.educational_materials.Theme;
import com.wawa.wawa_educational_materials.models.educational_materials.activities.Questionary;
import lombok.*;

import java.io.BufferedReader;
import java.io.FileReader;

@Data
public class AdapterMaterial {

    @SneakyThrows
    public EducationalMaterial createEducationalMaterial(int idCourse, int idMaterial) {

        String route = EducationalMaterial.getRoute(idCourse, idMaterial);
        BufferedReader br = new BufferedReader(new FileReader(route));
        String line;
        line = br.readLine();
        String[] parts = line.split("=",2);
        return switch (parts[1]) {
            case "Tema" -> new Theme(idMaterial, route);
            case "Cuestionario" -> new Questionary(idMaterial, route);
            default -> null;
        };
    }
}