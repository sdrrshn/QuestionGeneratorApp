package com.sdrrshn.questiongeneratorapp.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question_category_tb")
@Data
public class QuestionCategoryEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = QuestionEntity.class, mappedBy = "categoryEntity")
    private List<QuestionEntity> questionEntities;
}
