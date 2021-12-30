package com.rehabilitation.demo.payload;

import com.rehabilitation.demo.models.UserData;

import java.util.Date;

public class AddPostRequest {

    private String comment;
    private Date commentDate;
    private Integer rate;
    private Long assignedId;
    private Long authorId;

    public AddPostRequest(){

    }

    public AddPostRequest(String comment, Date commentDate, Integer rate, Long assignedId, Long authorId) {
        this.comment = comment;
        this.commentDate = commentDate;
        this.rate = rate;
        this.assignedId = assignedId;
        this.authorId = authorId;
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

    public Long getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(Long assignedId) {
        this.assignedId = assignedId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
