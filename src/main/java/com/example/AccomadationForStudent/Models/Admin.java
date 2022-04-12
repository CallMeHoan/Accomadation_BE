package com.example.AccomadationForStudent.Models;

import javax.persistence.*;

@Entity
@Table(name= "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;

    public Admin(Long id, String code) {
        this.id = id;
        this.code = code;
    }

    public Admin(String code) {
        this.code = code;
    }

    public Admin() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
