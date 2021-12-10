package com.rehabilitation.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;
    private Date commentDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_data_messageSender")
    private UserData sender;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_data_messageReceiver")
    private UserData receiver;

    public Messages(){}

    public Messages(String comment, Date commentDate, UserData sender, UserData receiver) {
        this.comment = comment;
        this.commentDate = commentDate;
        this.sender = sender;
        this.receiver = receiver;
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

    public UserData getSender() {
        return sender;
    }

    public void setSender(UserData sender) {
        this.sender = sender;
    }

    public UserData getReceiver() {
        return receiver;
    }

    public void setReceiver(UserData receiver) {
        this.receiver = receiver;
    }
}
