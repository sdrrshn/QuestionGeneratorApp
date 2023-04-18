package com.sdrrshn.questiongeneratorapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "user_tb")
@Entity
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "username")
    private String username;

    @Column(name = "user_last_name")
    private String userLastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userEntity")
    private List<QuestionEntity> questionEntities=new ArrayList<>();


}
