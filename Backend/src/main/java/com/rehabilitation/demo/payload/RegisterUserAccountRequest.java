package com.rehabilitation.demo.payload;

public class RegisterUserAccountRequest {

    private String physioId;
    private String email;
    private String password;
    private String name;
    private String surname;

    public RegisterUserAccountRequest() {
    }

    public RegisterUserAccountRequest(String physioId, String email, String password, String name, String surname) {
        this.physioId = physioId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public String getPhysioId() {
        return physioId;
    }

    public void setPhysioId(String physioId) {
        this.physioId = physioId;
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
                "physio id='" + physioId + '\'' +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
