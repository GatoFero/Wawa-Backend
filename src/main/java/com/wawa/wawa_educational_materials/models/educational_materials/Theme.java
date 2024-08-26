package com.wawa.wawa_educational_materials.models.educational_materials;

import com.wawa.wawa_educational_materials.entities.Author;
import com.wawa.wawa_educational_materials.models.AuthorDTO;
import lombok.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Theme implements EducationalMaterial{

    private int id;
    private String section;
    private String name;
    private List<String> subTitles;
    private List<String> contents;
    private List<String> examples;
    private List<String> references;
    private int idAuthor;
    private AuthorDTO author;

    public Theme(int id, String route) {
        this.id = id;
        readFile(route);
    }

    @Override
    public void fillData(Map<String, String> data){
        this.section = data.get("section");
        this.name = data.get("name");
        this.idAuthor = Integer.parseInt(data.get("idAuthor"));
        this.subTitles = setData(data.get("subTitles"));
        this.contents = setData(data.get("contents"));
        this.examples = setData(data.get("examples"));
        this.references = setData(data.get("references"));
    }
}