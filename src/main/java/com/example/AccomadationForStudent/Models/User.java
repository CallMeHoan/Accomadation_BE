package com.example.AccomadationForStudent.Models;


import javax.persistence.*;

@Entity
@Table(name="`users`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String birthday;
    private String phone;
    private String gender;
    private String mail;

    public User() {}

    public User(String name, String birthday, String phone, String gender, String mail) {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;
        this.mail = mail;
    }

    public User(Long id, String name, String birthday, String phone, String gender, String mail) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
