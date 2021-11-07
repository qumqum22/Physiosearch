package com.rehabilitation.demo.models;
import com.fasterxml.jackson.annotation.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String name;
    private String surname;
    private String gender;
    private Date birthday;
    @Value(value = "${profileImage:https://t3.ftcdn.net/jpg/00/64/67/80/360_F_64678017_zUpiZFjj04cnLri7oADnyMH0XBYyQghG.jpg}")
    private String profileImage;
    private String description;

    @OneToOne(mappedBy = "userdata",cascade=CascadeType.ALL)
    private UserAccount userAccount;

    //@JsonManagedReference
    @OneToMany(mappedBy = "userdata",cascade=CascadeType.ALL)
    private Set<Phones> phones = new HashSet<>();

    //@JsonManagedReference
    @OneToMany(mappedBy = "userdata",cascade=CascadeType.ALL)
    private Set<Specializations> specializations = new HashSet<>();

    //@JsonManagedReference
    @OneToMany(mappedBy = "assigned",cascade=CascadeType.ALL)
    private Set<Comments> commentsAbout = new HashSet<>();

    //@JsonManagedReference
    @OneToMany(mappedBy = "author",cascade=CascadeType.ALL)
    private Set<Comments> commentsOwned = new HashSet<>();

    //@JsonManagedReference
    @OneToMany(mappedBy = "sender",cascade=CascadeType.ALL)
    private Set<CzatMessages> messageSender = new HashSet<>();

    //@JsonManagedReference
    @OneToMany(mappedBy = "receiver",cascade=CascadeType.ALL)
    private Set<CzatMessages> messageReceiver = new HashSet<>();

    @OneToMany(mappedBy = "userdata")
    private Set<ExternalContacts> externalContacts;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
            CascadeType.ALL})
    @JoinTable(name="user_address",
    joinColumns =  { @JoinColumn(name= "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "address_id") })
    private Set<Address> address = new HashSet<>();

    @OneToMany(mappedBy = "userdata",cascade=CascadeType.ALL)
    private Set<UserRights> userRights;

    @OneToMany(mappedBy = "userdata",cascade=CascadeType.ALL)
    private Set<Videos> videos;

    public UserData(){

    }

    public UserData(String title, String name, String surname,
                    String gender, Date birthday, String profileImage,
                    String description){
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
        this.profileImage = profileImage;
        this.description = description;
    }

    public void removeAddress(Address addressToRemove){
        address.remove(addressToRemove);
        addressToRemove.getUserdata().remove(this);
    }
    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", description='" + description + '\'' +
                ", externalContacts=" + externalContacts +
                ", address=" + address +
                ", userRights=" + userRights +
                ", videos=" + videos +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Phones> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phones> phones) {
        this.phones = phones;
    }

    public Set<ExternalContacts> getExternalContacts() {
        return externalContacts;
    }

    public void setExternalContacts(Set<ExternalContacts> externalContacts) {
        this.externalContacts = externalContacts;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    public Set<UserRights> getUserRights() {
        return userRights;
    }

    public void setUserRights(Set<UserRights> userRights) {
        this.userRights = userRights;
    }

    public Set<Videos> getVideos() {
        return videos;
    }

    public void setVideos(Set<Videos> videos) {
        this.videos = videos;
    }

    public Set<Comments> getCommentsAbout() {
        return commentsAbout;
    }

    public void setCommentsAbout(Set<Comments> commentsAbout) {
        this.commentsAbout = commentsAbout;
    }

    public Set<Comments> getCommentsOwned() {
        return commentsOwned;
    }

    public void setCommentsOwned(Set<Comments> commentsOwned) {
        this.commentsOwned = commentsOwned;
    }

    public UserAccount getUser() {
        return userAccount;
    }

    public void setUser(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}