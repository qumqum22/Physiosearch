package com.rehabilitation.demo.models;

import javax.persistence.*;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    //private Integer rehabilitantID;
    private String email;
    private String password;
    private String salt;
    private String seed;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_data_user", referencedColumnName = "id")
    private UserData userdata;

    public UserAccount(){

    }

    public UserAccount(String email, String password, String salt, String seed, UserData userdata) {
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.seed = seed;
        this.userdata = userdata;
    }

    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }
}
