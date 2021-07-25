package com.rehabilitation.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Videos {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Date uploadDate;
    private String description;
    private String image;
    private String video;
    private Long likes;
    private Long dislikes;
    private Long subscribers;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="id", nullable = false)
    private UserData userdata;


    public Videos(){

    }

    public Videos(String name, Date uploadDate, String description, String image, String video, Long likes, Long dislikes, Long subscribers) {
        this.name = name;
        this.uploadDate = uploadDate;
        this.description = description;
        this.image = image;
        this.video = video;
        this.likes = likes;
        this.dislikes = dislikes;
        this.subscribers = subscribers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public void setDislikes(Long dislikes) {
        this.dislikes = dislikes;
    }

    public Long getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Long subscribers) {
        this.subscribers = subscribers;
    }
}
