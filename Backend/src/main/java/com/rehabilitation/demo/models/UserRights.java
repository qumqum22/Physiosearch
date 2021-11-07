package com.rehabilitation.demo.models;


import javax.persistence.*;

@Entity
public class UserRights {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accessRights;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="id", nullable = false)
    private UserData userdata;

    public UserRights(){

    }

    public UserRights(String accessRights) {
        this.accessRights = accessRights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(String accessRights) {
        this.accessRights = accessRights;
    }
}
