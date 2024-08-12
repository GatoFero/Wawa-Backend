package com.wawa.wawa.dtos;

import com.wawa.wawa.models.EducationalMaterial;
import lombok.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EducationalMaterialDto implements EducationalMaterial {

    private int id;
    private String name;
    private String section;
    private String type;

    public EducationalMaterialDto(int idCourse, int idMaterial) {
        String route = EducationalMaterial.getRuta(idCourse, idMaterial);
        this.id = idMaterial;
        readFile(route);
    }

    @SneakyThrows
    @Override
    public void readFile(String route) {
        Map<String,String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(route));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("=");
            map.put(parts[0], parts[1]);
        }
        this.name = map.get("name");
        this.section = map.get("section");
        this.type = map.get("type");
    }
}
