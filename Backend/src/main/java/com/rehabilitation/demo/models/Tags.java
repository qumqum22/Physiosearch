package com.rehabilitation.demo.models;

import javax.persistence.*;

@Entity
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tagName;




    public Tags(){

    }



    public Tags(String tagName) {
        this.tagName = tagName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
