package com.wawa.wawa.dtos;

import com.wawa.wawa.entity.Course;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProgressDto {

    private String state;
    private Float progress;
    private Integer materialsCompleted;
    private Course course;
}
