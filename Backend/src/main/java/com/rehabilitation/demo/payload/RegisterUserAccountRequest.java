package com.rehabilitation.demo.payload;

public class RegisterUserAccountRequest {

    private Long id;
    private Integer rehabilitantId;
    private String email;
    private String password;
    private String name;
    private String surname;

    public RegisterUserAccountRequest() {
    }

    public RegisterUserAccountRequest(Integer rehabilitantId, String email, String password, String name, String surname) {
        this.rehabilitantId = rehabilitantId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRehabilitantId() {
        return rehabilitantId;
    }

    public void setRehabilitantId(Integer rehabilitantId) {
        this.rehabilitantId = rehabilitantId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "RegisterUserAccountRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
