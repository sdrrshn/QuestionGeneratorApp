package com.sdrrshn.questiongeneratorapp.service.concretes;

import com.sdrrshn.questiongeneratorapp.data.dto.QuestionAdd;
import com.sdrrshn.questiongeneratorapp.entity.QuestionEntity;
import com.sdrrshn.questiongeneratorapp.mapper.QuestionMapper;
import com.sdrrshn.questiongeneratorapp.repository.QuestionEntityRepository;
import com.sdrrshn.questiongeneratorapp.service.abstracts.IQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {
    private final QuestionEntityRepository repository;
    private final QuestionMapper questionMapper;

    public QuestionService(QuestionEntityRepository repository, QuestionMapper questionMapper) {
        this.repository = repository;
        this.questionMapper = questionMapper;
    }

    @Override
    public QuestionAdd add(QuestionAdd questionAdd) {
        QuestionEntity questionEntity= questionMapper.questionAddToQuestionEntity(questionAdd);
        return questionMapper.questionEntityToQuestionAdd(repository.save(questionEntity));
    }

    @Override
    public List<QuestionAdd> getAll() {
        return questionMapper.questionEntityToQuestionAdd(repository.findAll());
    }
}
