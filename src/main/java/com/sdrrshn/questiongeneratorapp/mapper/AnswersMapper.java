package com.sdrrshn.questiongeneratorapp.mapper;

import com.sdrrshn.questiongeneratorapp.data.dto.Answers;
import com.sdrrshn.questiongeneratorapp.entity.AnswersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AnswersMapper {


    @Named("answersToAnswersEntity")
    AnswersEntity answersToAnswersEntity(Answers answers);

    @Named("answersEntityToAnswers")
    Answers answersEntityToAnswers(AnswersEntity answersEntity);
}
