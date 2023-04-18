package com.sdrrshn.questiongeneratorapp.entity;
import jakarta.persistence.*;
import lombok.Data;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionEntity")
    private List<AnswersEntity> answersEntities = new java.util.ArrayList<>();




}
