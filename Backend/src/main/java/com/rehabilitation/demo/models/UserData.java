package com.rehabilitation.demo.models;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
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