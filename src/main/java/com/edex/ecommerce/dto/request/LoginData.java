package com.edex.ecommerce.dto.request;

public class LoginData {
    private String username;
    private String password;
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
}

//DTO => Data Transfer Object
    // requeest DTO
    // response DTO
//POJO Plain Old Java Object
//Encapsulation
//  1. Hiding the data members
//  2. Providing getter/setter methods for accessing the data members


