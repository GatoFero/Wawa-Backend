package com.wawa.wawa_educational_materials.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wawa.wawa_educational_materials.models.educational_materials.EducationalMaterial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Course {

    @Id
    private String id;
    private String name;
    private String description;

    @DBRef
    private List<EducationalMaterial> educationalMaterials;

    @JsonProperty("cantEducationalMaterials")
    public int getCantEducationalMaterials() {
        return educationalMaterials != null ? educationalMaterials.size() : 0;
    }
}
