package com.wawa.wawa.models;

import java.util.Arrays;
import java.util.List;

public interface EducationalMaterial {

    void readFile(String route);

    default List<String> readSection(String value) {
        return value != null ? Arrays.asList(value.split("--")) : null;
    }
}
