package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "personel")
public class Personel {

    @Id
    @Column(name = "id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int personelId;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date birthOfDate;

    // oersonel_personelId
    // phoneNumbers
    @ElementCollection                                          // foreign key ataması.
    @CollectionTable(name = "personelPphoneNumber", joinColumns = @JoinColumn(name = "personelId"))
    @Column(name = "phoneNumber")
    private List<String> phoneNumbers = new ArrayList<String>();


    public Personel() {

    }

    public Personel(String firstName, String lastName, Date birthOfDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthOfDate = birthOfDate;
    }


    public int getPersonelId() {
        return personelId;
    }

    public void setPersonelId(int personelId) {
        this.personelId = personelId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
