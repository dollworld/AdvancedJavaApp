package com.example.Advanced.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.time.LocalDateTime;


@Entity
public class UserInfo {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column (nullable = false)
    private String name;

    @Column (unique = true, nullable = false)
    private String username;

    @Column (nullable = false)
    private String password;

    @Column  (nullable = false)
    @Email(message="Please provide a valid email address")
    private String email;

    @Column (nullable = false)
    private String roles;

    public UserInfo(){}

    public UserInfo(String name, String username, String email,String password, String roles){
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.username = username;
    }

    //getters n setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
