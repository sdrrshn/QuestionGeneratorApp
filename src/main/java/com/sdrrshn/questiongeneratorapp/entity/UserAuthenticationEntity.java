package com.sdrrshn.questiongeneratorapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "user_authentication_tb")
@Entity
public class UserAuthenticationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Column(name = "auth_code")
    private String authCode;

    @Column(name = "create_date")
    private LocalDateTime createDate= LocalDateTime.now();
}
