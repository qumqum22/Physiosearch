package com.rehabilitation.demo.payload;

import java.util.Date;

public class UserDataRequest {

    private Long id;
    private String title;
    private String name;
    private String surname;
    private String gender;
    private Date birthday;
    private String profileImage;
    private String description;
    private String physioID;

    public UserDataRequest(){

    }

    public UserDataRequest(Long id, String title, String name, String surname, String gender, Date birthday, String profileImage, String description, String physioID) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
        this.profileImage = profileImage;
        this.description = description;
        this.physioID = physioID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhysioID() {
        return physioID;
    }

    public void setPhysioID(String physioID) {
        this.physioID = physioID;
    }
}