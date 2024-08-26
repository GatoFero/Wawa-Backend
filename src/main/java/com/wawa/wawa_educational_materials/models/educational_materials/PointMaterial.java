package com.wawa.wawa_educational_materials.models.educational_materials;

import lombok.*;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PointMaterial implements EducationalMaterial{

    private int id;
    private String name;
    private String section;
    private String type;

    public PointMaterial(int idMaterial, String route){
        this.id = idMaterial;
        readFile(route);
    }

    @Override
    public void fillData(Map<String, String> data) {
        setType(data.get("type"));
        setName(data.get("name"));
        setSection(data.get("section"));
    }
}
