package com.wawa.wawa_educational_materials.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Author{

    @Id
    private Integer id;
    private String name;
    private String email;

    private String youtube;
    private String facebook;
    private String tiktok;
}
