package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Kullanıcı")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private  String password;
    @Embedded
    //@AttributeOverride(name = "phoneNumber",column = @Column(name = "telefon"))
    @AttributeOverrides({
            @AttributeOverride(name = "phoneNumber",column = @Column(name = "telefon")),
            @AttributeOverride(name = "email",column = @Column(name = "eposta",unique = true))
    })
    private  Contact contact;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public User(){}

    public User(String userName, String password, Contact contact, Date creationDate) {
        this.userName = userName;
        this.password = password;
        this.contact = contact;
        this.creationDate = creationDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
