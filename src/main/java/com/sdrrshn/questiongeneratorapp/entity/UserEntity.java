package com.sdrrshn.questiongeneratorapp.entity;


import com.sdrrshn.questiongeneratorapp.data.enums.UserStatus;
import lombok.Data;

import javax.persistence.*;
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

    @Column(name = "name",nullable = false)
    private String name;


    @Column(name = "username",nullable = false,unique = true)
    private String username;

    @Column(name = "user_last_name",nullable = false)
    private String userLastName;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "phone",unique = true)
    private String phone;

    @Column(name = "status")
    private UserStatus status=UserStatus.CREATED;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userEntity")
    private List<QuestionEntity> questionEntities = new ArrayList<>();


}
