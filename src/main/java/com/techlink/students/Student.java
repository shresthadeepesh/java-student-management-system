/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.students;

import java.util.Date;

public class Student {

    private int id;

    private String name;

    private String email;

    private String password;

    private String address;

    private String grade;

    private Date dob;

    private String phone;

    private String guardianName;

    private Gender gender;

    private Date joinedAt;

    public Student() {

    }

    public Student(int id, String name, String email, String password, String address, String grade, Date dob, String phone, String guardianName, Gender gender, Date joinedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.grade = grade;
        this.dob = dob;
        this.phone = phone;
        this.guardianName = guardianName;
        this.gender = gender;
        this.joinedAt = joinedAt;
    }

    public Student(String name, String email, String password, String address, String grade, Date dob, String phone, String guardianName, Gender gender, Date joinedAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.grade = grade;
        this.dob = dob;
        this.phone = phone;
        this.guardianName = guardianName;
        this.gender = gender;
        this.joinedAt = joinedAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrade() {
        return grade;
    }

    public Date getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getJoinedAt() {
        return joinedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setJoinedAt(Date joinedAt) {
        this.joinedAt = joinedAt;
    }
}
