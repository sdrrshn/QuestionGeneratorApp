package com.sdrrshn.questiongeneratorapp.mapper;

import com.sdrrshn.questiongeneratorapp.data.dto.QuestionAdd;
import com.sdrrshn.questiongeneratorapp.entity.QuestionEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",uses = {AnswersMapper.class})
public interface QuestionMapper {

    @Named("questionEntityToQuestionAdd")
    @Mapping(source = "answersEntities",target = "answersEntities",qualifiedByName = "answersEntityToAnswers")
    QuestionAdd questionEntityToQuestionAdd(QuestionEntity questionEntity);

    @IterableMapping(qualifiedByName = "questionEntityToQuestionAdd")
    List<QuestionAdd> questionEntityToQuestionAdd(List<QuestionEntity> questionEntities);

    @Named("questionAddToQuestionEntity")
    @Mapping(source = "answersEntities",target = "answersEntities",qualifiedByName = "answersToAnswersEntity")
    QuestionEntity questionAddToQuestionEntity(QuestionAdd questionAdd);

}
