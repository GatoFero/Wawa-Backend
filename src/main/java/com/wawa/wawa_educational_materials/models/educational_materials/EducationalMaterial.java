package com.wawa.wawa_educational_materials.models.educational_materials;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EducationalMaterial {

    @SneakyThrows
    default void readFile(String route){
        Map<String,String> data = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(route));
        String line;
        br.readLine();
        while ((line = br.readLine()) != null){
            String[] parts = line.split("=",2);
            data.put(parts[0],parts[1]);
        }
        br.close();
        fillData(data);
    }

    static String getRoute(int idCourse, int idMaterial){
       return "src/main/resources/files/courses/" + idMaterial + "/materials/" + idCourse + ".txt";
    }

    static String getDirectory(){
        return "src/main/resources/files/courses";
    }

    default List<String> setData(String value) {
        return value != null ? Arrays.asList(value.split("--")) : null;
    }

    void fillData(Map<String, String> data);
}