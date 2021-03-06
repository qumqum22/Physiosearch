package com.rehabilitation.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class OfficeHours {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer day;
    private Time open_time;
    private Time close_time;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_data_id")
    private UserData userdata;

    public OfficeHours(){}

    public OfficeHours(Integer day, Time open_time, Time close_time, UserData userdata) {
        this.day = day;
        this.open_time = open_time;
        this.close_time = close_time;
        this.userdata = userdata;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Time getOpen_time() {
        return open_time;
    }

    public void setOpen_time(Time open_time) {
        this.open_time = open_time;
    }

    public Time getClose_time() {
        return close_time;
    }

    public void setClose_time(Time close_time) {
        this.close_time = close_time;
    }

    public UserData getUserdata() {
        return userdata;
    }

    public void setUserdata(UserData userdata) {
        this.userdata = userdata;
    }
}
