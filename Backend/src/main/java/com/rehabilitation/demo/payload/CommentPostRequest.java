package com.rehabilitation.demo.payload;

import java.util.Date;

public class CommentPostRequest {

    private Long id;
    private String comment;
    private Date commentDate;
    private Integer rate;
    private Long authorId;
    private String name;
    private String surname;
    private String profileImage;

    public CommentPostRequest(Long id, String comment, Date commentDate, Integer rate, Long authorId, String name, String surname, String profileImage) {
        this.id = id;
        this.comment = comment;
        this.commentDate = commentDate;
        this.rate = rate;
        this.authorId = authorId;
        this.name = name;
        this.surname = surname;
        this.profileImage = profileImage;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
