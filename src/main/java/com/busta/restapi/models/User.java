package com.busta.restapi.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String fullname;

    @Column(unique = true)
    private String email;

    public void setUsername(String username){
        this.fullname=username;
    }

    public String getUsername(){
        return fullname;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }
}

