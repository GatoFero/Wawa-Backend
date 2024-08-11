package com.wawa.wawa.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourseDto {

    private Integer id;
    private String name;
    private String description;
}
