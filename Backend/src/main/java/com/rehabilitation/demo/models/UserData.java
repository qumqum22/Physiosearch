package com.rehabilitation.demo.models;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
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
    @Value(value = "0")
    private String physioID; // unique, ale gdy nie istnieje?

    @OneToOne(mappedBy = "userdata",cascade=CascadeType.ALL)
    private UserAccount userAccount;

    //@JsonManagedReference
    @OneToMany(mappedBy = "userdata",cascade=CascadeType.ALL)
    private Set<Phones> phones = new HashSet<>();

    //@JsonManagedReference
    @OneToMany(mappedBy = "userdata",cascade=CascadeType.ALL)
    private Set<OfficeHours> officeHours = new HashSet<>();

    //@JsonManagedReference
    @OneToMany(mappedBy = "assigned",cascade=CascadeType.ALL)
    private Set<Comments> commentsAbout = new HashSet<>();

    //@JsonManagedReference
    @OneToMany(mappedBy = "author",cascade=CascadeType.ALL)
    private Set<Comments> commentsOwned = new HashSet<>();

    //@JsonManagedReference
    @OneToMany(mappedBy = "sender",cascade=CascadeType.ALL)
    private Set<Messages> messageSender = new HashSet<>();

    //@JsonManagedReference
    @OneToMany(mappedBy = "receiver",cascade=CascadeType.ALL)
    private Set<Messages> messageReceiver = new HashSet<>();

    @OneToMany(mappedBy = "userdata")
    private Set<ExternalContacts> externalContacts;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL})
    @JoinTable(name="userdata_rehabilitations",
    joinColumns =  { @JoinColumn(name= "userdata_id")},
    inverseJoinColumns = {@JoinColumn(name = "rehabilitation_id")})
    private Set<Rehabilitations> rehabilitations = new HashSet<>();

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
            CascadeType.ALL})
    @JoinTable(name="userdata_clinic",
    joinColumns =  { @JoinColumn(name= "userdata_id")},
    inverseJoinColumns = {@JoinColumn(name = "clinic_id") })
    private Set<Clinic> clinics = new HashSet<>();

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL})
    @JoinTable(name="userdata_right",
            joinColumns =  { @JoinColumn(name= "userdata_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_rights_id") })
    private Set<UserRights> rights = new HashSet<>();

    public UserData(){

    }

    public UserData(String title, String name, String surname, String gender, Date birthday,
                    String profileImage, String description, String physioID) {
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
        this.profileImage = profileImage;
        this.description = description;
        this.physioID = physioID;
    }

    public void removeClinic(Clinic clinicToRemove){
        clinics.remove(clinicToRemove);
        clinicToRemove.getUserdata().remove(this);
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

    public String getPhysioID() {
        return physioID;
    }

    public void setPhysioID(String physioID) {
        this.physioID = physioID;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Set<Phones> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phones> phones) {
        this.phones = phones;
    }

    public Set<OfficeHours> getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(Set<OfficeHours> officeHours) {
        this.officeHours = officeHours;
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

    public Set<Messages> getMessageSender() {
        return messageSender;
    }

    public void setMessageSender(Set<Messages> messageSender) {
        this.messageSender = messageSender;
    }

    public Set<Messages> getMessageReceiver() {
        return messageReceiver;
    }

    public void setMessageReceiver(Set<Messages> messageReceiver) {
        this.messageReceiver = messageReceiver;
    }

    public Set<ExternalContacts> getExternalContacts() {
        return externalContacts;
    }

    public void setExternalContacts(Set<ExternalContacts> externalContacts) {
        this.externalContacts = externalContacts;
    }

    public Set<Rehabilitations> getRehabilitations() {
        return rehabilitations;
    }

    public void setRehabilitations(Set<Rehabilitations> rehabilitations) {
        this.rehabilitations = rehabilitations;
    }

    public Set<Clinic> getClinics() {
        return clinics;
    }

    public void setClinics(Set<Clinic> clinics) {
        this.clinics = clinics;
    }

    public Set<UserRights> getRights() {
        return rights;
    }

    public void setRights(Set<UserRights> rights) {
        this.rights = rights;
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
                ", clinics=" + clinics +
                ", userRights=" + rights +
                '}';
    }
}