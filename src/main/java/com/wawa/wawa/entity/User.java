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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;

    private boolean vip;

    private Integer level;
    private Integer top;

    @OneToMany(targetEntity = Progress.class, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Progress> progress;

    @ManyToMany(targetEntity = Achievement.class, fetch = FetchType.LAZY)
    private List<Achievement> achievements;
}
