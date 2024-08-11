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
        BufferedReader br = new BufferedReader(new FileReader(getRuta(idCourse,idMaterial)));
        String line;
        line = br.readLine();
        switch (line){
            case "theme":
                educationalMaterial = new Theme(getRuta(idCourse,idMaterial));
                break;
            case "activity":
                System.out.println("ga");
                break;
            default:
                break;
        }
    }

    private String getRuta(int idCurse, int idEducationalMaterial){
        return "src/main/resources/files/courses/"+idCurse+"/"+idEducationalMaterial+".txt";
    }
}