package com.bitm.android.studentmanagementsystem.models;

import android.graphics.Bitmap;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_stu")
public class Student {
    @PrimaryKey(autoGenerate = true)

    private long id;

    private String name;
    private int age;
    private String mobile;
    private String emailAddress;
    public double CGPA;
    private String gender;
    private String dob;
    private String department;
    private String qualification;
    private String location;
    private String hobby;
    @Ignore
    private Bitmap image;

    public Student(String name, int age, String mobile, String emailAddress, double CGPA, String gender, String dob, String department, String qualification, String location, String hobby) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.emailAddress = emailAddress;
        this.CGPA = CGPA;
        this.gender = gender;
        this.dob = dob;
        this.department = department;
        this.qualification = qualification;
        this.location = location;
        this.hobby = hobby;
    }

    @Ignore
    public Student(long id, String name, int age, String mobile, String emailAddress, double CGPA, String gender, String dob, String department, String qualification, String location, String hobby) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.emailAddress = emailAddress;
        this.CGPA = CGPA;
        this.gender = gender;
        this.dob = dob;
        this.department = department;
        this.qualification = qualification;
        this.location = location;
        this.hobby = hobby;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public double getCGPA() {
        return CGPA;
    }
    public String gCGPA(){
        String s= String.valueOf(CGPA);
        return s;
    }


    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mobile='" + mobile + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", salary=" + CGPA +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", department='" + department + '\'' +
                ", designation='" + qualification + '\'' +
                ", location='" + location + '\'' +
                ", allowances='" + hobby + '\'' +
                ", image=" + image +
                '}';
    }
}
