package com.sdrrshn.questiongeneratorapp.service.abstracts;

import com.sdrrshn.questiongeneratorapp.data.dto.QuestionAdd;

import java.util.List;

public interface IQuestionService {

    QuestionAdd add(QuestionAdd questionAdd);

    List<QuestionAdd> getAll();
}
