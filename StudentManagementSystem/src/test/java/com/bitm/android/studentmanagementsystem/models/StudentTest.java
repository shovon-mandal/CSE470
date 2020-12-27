package com.bitm.android.studentmanagementsystem.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    Student s= new Student();


    @Test
    public void setCGPA() {
        Double input=3.66;
        boolean output;
        boolean expected=true;

        output=s.setCGPA(input);
        assertEquals(expected,output);
    }


    @Test
    public void setName() {
    String input="Shovon";
    s.setName(input);
    }

    @Test
    public void setAge() {
        int age=18;
        s.setAge(age);
    }

    @Test
    public void setMobile() {
        String mobileNumber="01911549671";
        s.setMobile(mobileNumber);
    }



    @Test
    public void setDepartment() {
        String Department ="CSE";
        s.setDepartment(Department);
    }

    @Test
    public void setQualification() {
        String Qualification="HSC";
        s.setQualification(Qualification);
    }

    @Test
    public void setLocation() {
        String Location="Khulna";
        s.setLocation(Location);
    }

    @Test
    public void setGender() {
        String Gender= "Male";
        s.setGender(Gender);
    }
}