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

    @Column(name = "status")
    private UserStatus status=UserStatus.CREATED;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userEntity")
    private List<QuestionEntity> questionEntities = new ArrayList<>();


}
