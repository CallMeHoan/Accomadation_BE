package com.example.AccomadationForStudent.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountName;
    private String password;
    private String userID;
    private String role;

    public Account() {
    }

    public Account(Long id, String accountName, String password, String userID, String role) {
        this.id = id;
        this.accountName = accountName;
        this.password = password;
        this.userID = userID;
        this.role = role;
    }

    public Account(String accountName, String password, String userID, String role) {
        this.accountName = accountName;
        this.password = password;
        this.userID = userID;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
