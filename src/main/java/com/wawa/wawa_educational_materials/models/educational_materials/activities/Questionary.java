package com.wawa.wawa_educational_materials.models.educational_materials.activities;

import com.wawa.wawa_educational_materials.entities.Author;
import com.wawa.wawa_educational_materials.models.AuthorDTO;
import com.wawa.wawa_educational_materials.models.educational_materials.Activity;
import com.wawa.wawa_educational_materials.models.educational_materials.EducationalMaterial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionary implements Activity, EducationalMaterial {

    private int id;
    private String section;
    private String name;
    private List<Question> questions;

    public Questionary(int id, String route){
        this.id = id;
        readFile(route);
    }

    @Override
    public void fillData(Map<String, String> data) {
        this.section = data.get("section");
        this.name = data.get("name");
        this.questions = createQuestions(data);
    }
    public List<Question> createQuestions(Map<String, String> data){

        List<String> questions = setData(data.get("questions"));
        List<String> firstOptions = setData(data.get("first_options"));
        List<String> secondOptions = setData(data.get("second_options"));
        List<String> thirdOptions = setData(data.get("third_options"));
        List<String> fourthOptions = setData(data.get("fourth_options"));
        List<String> response = setData(data.get("response"));

        return IntStream.range(0, questions.size())
                .mapToObj(i ->{
                    Question question = new Question();
                    question.setQuestion(questions.get(i));
                    question.setFirstOption(firstOptions.get(i));
                    question.setSecondOption(secondOptions.get(i));
                    question.setThirdOption(thirdOptions.get(i));
                    question.setFourthOption(fourthOptions.get(i));
                    question.setResponse(response.get(i));
                    return question;
                }).collect(Collectors.toList());
    }
}
