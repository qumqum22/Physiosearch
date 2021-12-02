package com.rehabilitation.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rehabilitations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String rehabilitationType;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "rehabilitations")
    private Set<UserData> userdata = new HashSet<>();

    public Rehabilitations(){

    }

    public Rehabilitations(String rehabilitationType) {
        this.rehabilitationType = rehabilitationType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRehabilitationType() {
        return rehabilitationType;
    }

    public void setRehabilitationType(String tagName) {
        this.rehabilitationType = tagName;
    }

    public Set<UserData> getUserdata() {
        return userdata;
    }

    public void setUserdata(Set<UserData> userdata) {
        this.userdata = userdata;
    }
}
