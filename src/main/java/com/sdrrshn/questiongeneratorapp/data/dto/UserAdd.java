package com.sdrrshn.questiongeneratorapp.data.dto;

import lombok.Data;

@Data
public class UserAdd {
    private String email;
    private String name;
    private String lastName;
    private String username;
    private String password;
    private String phone;
}
