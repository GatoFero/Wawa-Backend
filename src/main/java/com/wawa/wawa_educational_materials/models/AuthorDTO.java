package com.wawa.wawa_educational_materials.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private String name;
    private String email;

    private String youtube;
    private String facebook;
    private String tiktok;
}