package com.cupcodeteam.agentclubs.entity;

import javax.persistence.*;

@Entity
@Table(name = "register")
public class Register {
    private Integer id;
    private String email;
    private String name;
    private String lastName;
    private String password;
    private String confermPassword;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "conferm_password")
    public String getConfermPassword() {
        return confermPassword;
    }

    public void setConfermPassword(String confermPassword) {
        this.confermPassword = confermPassword;
    }
}
