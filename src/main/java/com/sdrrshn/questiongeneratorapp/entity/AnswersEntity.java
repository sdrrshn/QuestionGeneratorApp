package com.sdrrshn.questiongeneratorapp.entity;


import lombok.Data;

import javax.persistence.*;


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
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "question_entity_id")
    private QuestionEntity questionEntity;

}