package com.sdrrshn.questiongeneratorapp.data.dto;


import lombok.*;


public class UserAdd {
    private String email;
    private String name;
    private String userLastName;
    private String username;
    private String password;
    private String phone;

    public UserAdd() {

    }

    public UserAdd(String email, String name, String userLastName, String username, String password, String phone) {
        this.email = email;
        this.name = name;
        this.userLastName = userLastName;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
