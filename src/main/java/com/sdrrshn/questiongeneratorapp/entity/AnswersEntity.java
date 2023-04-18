package com.sdrrshn.questiongeneratorapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "answers_tb")
public class AnswersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "is_true")
    private boolean isTrue;
    @ManyToOne
    @JoinColumn(name = "question_entity_id")
    private QuestionEntity questionEntity;

}