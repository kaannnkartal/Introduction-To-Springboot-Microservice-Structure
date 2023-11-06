package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Student {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.TABLE)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String firstName;
    private String lastName;
    private Date birthOfDate;


    public Student(){}


    public Student(String firstName, String lastName, Date birthOfDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthOfDate = birthOfDate;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
}
