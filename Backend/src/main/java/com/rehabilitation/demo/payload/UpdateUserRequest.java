package com.rehabilitation.demo.payload;

public class UpdateUserRequest {

    private String name;
    private String surname;
    private String title;
    private String description;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String name, String surname, String title, String description) {
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.description = description;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
