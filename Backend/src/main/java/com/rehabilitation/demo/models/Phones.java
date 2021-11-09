package com.rehabilitation.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Phones {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String phoneNumber;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_data_id")
    private UserData userdata;

    public Phones(){

    }

    public Phones(String phoneNumber, UserData userdata) {
        this.phoneNumber = phoneNumber;
        this.userdata = userdata;
    }

    @Override
    public String toString() {
        return "Phones{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserData getUserdata() {
        return userdata;
    }

}
