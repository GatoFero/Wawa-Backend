package com.wawa.wawa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    private Integer cantThemes;
    private Integer cantActivities;
    private Integer cantExams;

    @JsonIgnore
    @OneToMany(targetEntity = Progress.class, fetch = FetchType.LAZY, mappedBy = "course")
    private List<Progress> progresses;
}
