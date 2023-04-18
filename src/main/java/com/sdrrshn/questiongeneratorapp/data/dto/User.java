package com.sdrrshn.questiongeneratorapp.data.dto;


import lombok.Data;

@Data
public class User {
    private Long id;
    private String email;
    private String name;
    private String userLastName;
    private String username;
    private String password;
    private String phone;

}
