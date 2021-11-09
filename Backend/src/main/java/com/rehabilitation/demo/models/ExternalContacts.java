package com.rehabilitation.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ExternalContacts {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String link;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="id", nullable = false)
    private UserData userdata;

    public ExternalContacts(){

    }

    public ExternalContacts(String link) {
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
