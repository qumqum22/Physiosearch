package com.rehabilitation.demo.models;


import javax.persistence.*;

@Entity
public class UserRights {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="id", nullable = false)
    private UserData userdata;

    public UserRights(){

    }

    public UserRights(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
