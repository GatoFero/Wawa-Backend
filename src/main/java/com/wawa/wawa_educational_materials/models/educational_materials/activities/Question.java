package com.wawa.wawa_educational_materials.models.educational_materials.activities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    private String question;
    private String firstOption;
    private String secondOption;
    private String thirdOption;
    private String fourthOption;
    private String response;
}