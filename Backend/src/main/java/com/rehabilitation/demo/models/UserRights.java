package com.rehabilitation.demo.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserRights {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accessRights;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "rights")
    private Set<UserData> userdata = new HashSet<>();

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

    public Set<UserData> getUserdata() {
        return userdata;
    }

    public void setUserdata(Set<UserData> userdata) {
        this.userdata = userdata;
    }
}
