package com.wawa.wawa.models;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;

public interface EducationalMaterial {

    void readFile(String route);

    @SneakyThrows
    static String getRuta(int idCurse, int idEducationalMaterial){
        return "src/main/resources/files/courses/"+idCurse+"/"+idEducationalMaterial+".txt";
    }
    default List<String> readSection(String value) {
        return value != null ? Arrays.asList(value.split("--")) : null;
    }
}
