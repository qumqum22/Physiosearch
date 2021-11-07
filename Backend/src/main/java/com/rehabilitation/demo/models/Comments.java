package com.rehabilitation.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;
    private Date commentDate;
    private Integer rate;

    @ManyToOne
    @JoinColumn(name="user_data_commentsAbout")
    private UserData author;

    @ManyToOne
    @JoinColumn(name="user_data_commentsOwned")
    private UserData assigned;

    public Comments(){}

    public Comments(String comment, Date commentDate, Integer rate, UserData author, UserData assigned) {
        this.comment = comment;
        this.commentDate = commentDate;
        this.rate = rate;
        this.author = author;
        this.assigned = assigned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public UserData getAuthor() {
        return author;
    }

    public void setAuthor(UserData author) {
        this.author = author;
    }

    public UserData getAssigned() {
        return assigned;
    }

    public void setAssigned(UserData assigned) {
        this.assigned = assigned;
    }
}
