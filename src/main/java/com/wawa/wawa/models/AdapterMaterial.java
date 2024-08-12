package com.wawa.wawa.models;

import lombok.*;

import java.io.BufferedReader;
import java.io.FileReader;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdapterMaterial {

    private EducationalMaterial educationalMaterial;

    @SneakyThrows
    public void createMaterial(int idCourse, int idMaterial) {
        String route = EducationalMaterial.getRuta(idCourse, idMaterial);
        BufferedReader br = new BufferedReader(new FileReader(route));
        String line;
        line = br.readLine();
        String[] type = line.split("=");
        switch (type[1]){
            case "Tema":
                educationalMaterial = new Theme(route,idMaterial);
                break;
            case "activity":
                System.out.println("ga");
                break;
            default:
                break;
        }
    }
}