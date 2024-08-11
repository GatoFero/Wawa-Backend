package com.wawa.wawa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String state;
    private float progress;
    private int themesCompleted;
    private int activitiesCompleted;
    private int examsCompleted;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(targetEntity = Course.class, fetch = FetchType.LAZY)
    private Course course;
}
