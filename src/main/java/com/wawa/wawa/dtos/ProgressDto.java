package com.wawa.wawa.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProgressDto {

    private Integer id;
    private String state;
    private float progress;
    private int themesCompleted;
    private int activitiesCompleted;
    private int examsCompleted;
    private CourseDto course;
}
