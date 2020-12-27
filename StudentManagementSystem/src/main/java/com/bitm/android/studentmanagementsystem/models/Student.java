package com.bitm.android.studentmanagementsystem.models;

import android.graphics.Bitmap;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static org.junit.jupiter.api.Assertions.fail;

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

    public Student() {

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
        int c= name.length();
        if(c>0) {
            this.name = name;
        }else{
            fail();
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age>=12){
            this.age = age;
        }else{
            fail();
        }

    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        int c= mobile.length();
        if(c==11) {
            this.mobile = mobile;
        }else{
            fail();
        }

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


    public boolean setCGPA(double CGPA) {
        boolean b= false;
        if (CGPA <= 4 && CGPA >= 0) {
            this.CGPA = CGPA;
            b = true;
        }
        return b;
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
        int c= department.length();
        if(c>0) {
            this.department = department;
        }else{
            fail();
        }

    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        int c= qualification.length();
        if(c>0) {
            this.qualification = qualification;
        }else{
            fail();
        }

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        int c= location.length();
        if(c>0) {
            this.location = location;
        }else{
            fail();
        }


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
        int c= gender.length();
        if(c>0) {
            this.gender = gender;
        }else{
            fail();
        }

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
