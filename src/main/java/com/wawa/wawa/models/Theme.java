package com.wawa.wawa.models;

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
public class Theme implements EducationalMaterial{

    private String section;
    private String title;
    private List<String> subTitles;
    private List<String> contents;
    private List<String> examples;
    private Integer idAuthor;
    private List<String> seeMore;

    public Theme(String route){
        readFile(route);
    }

    @Override
    @SneakyThrows
    public void readFile(String route){
        Map<String,String> data = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(route));
        String line;
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] split = line.split("=",2);
            data.put(split[0],split[1]);
        }
        this.section = data.get("section");
        this.title = data.get("title");
        this.subTitles = readSection(data.get("subTitles"));
        this.contents = readSection(data.get("contents"));
        this.examples = readSection(data.get("examples"));
        this.seeMore = readSection(data.get("seeMore"));
    }
}
