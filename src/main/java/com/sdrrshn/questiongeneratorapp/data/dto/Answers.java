package com.sdrrshn.questiongeneratorapp.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdrrshn.questiongeneratorapp.entity.QuestionEntity;
import lombok.Data;

import javax.persistence.*;

@Data
public class Answers {

    @JsonProperty("answer")
    private String answerText;

    private boolean isTrue;

}
