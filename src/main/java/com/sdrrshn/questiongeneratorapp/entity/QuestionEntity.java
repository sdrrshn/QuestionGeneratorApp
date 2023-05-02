package com.sdrrshn.questiongeneratorapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "question_tb")
@Entity
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "question_text")
    private String questionText;


    @ManyToOne
    @JoinColumn(name = "user_entity_id")
    private UserEntity userEntity;


    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL, targetEntity = AnswersEntity.class)
    @JoinColumn(referencedColumnName = "id", name = "question_entity_id")
    private List<AnswersEntity> answersEntities = new java.util.ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "category_id")
    private QuestionCategoryEntity categoryEntity;

}
