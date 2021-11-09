package com.rehabilitation.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Specializations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String specializationName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_data_id")
    private UserData userdata;

    public Specializations(){

    }

    public Specializations(String specializationName, UserData userdata) {
        this.specializationName = specializationName;
        this.userdata = userdata;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String tagName) {
        this.specializationName = tagName;
    }

    public UserData getUserdata() {
        return userdata;
    }

    public void setUserdata(UserData userdata) {
        this.userdata = userdata;
    }
}
