package com.sdrrshn.questiongeneratorapp.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class QuestionAdd {

    @JsonProperty("question")
    private String questionText;

    @JsonProperty("directors")
    private User userEntity;
    @JsonProperty("answers")
    private List<Answers> answersEntities = new java.util.ArrayList<>();

}
