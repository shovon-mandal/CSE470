package com.bitm.android.studentmanagementsystem.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    Student s= new Student();


    @Test
    public void TestSetCGPATest() {
        Double input=3.66;
        boolean output;
        boolean expected=true;

        output=s.setCGPA(input);
        assertEquals(expected,output);
    }


    @Test
    public void TestSetName() {
    String input="Shovon";
    s.setName(input);
    }

    @Test
    public void TestSetAge() {
        int age=18;
        s.setAge(age);
    }

    @Test
    public void TestSetMobile() {
        String mobileNumber="01911549671";
        s.setMobile(mobileNumber);
    }



    @Test
    public void TestSetDepartment() {
        String Department ="CSE";
        s.setDepartment(Department);
    }

    @Test
    public void TestSetQualification() {
        String Qualification="HSC";
        s.setQualification(Qualification);
    }

    @Test
    public void TestSetLocation() {
        String Location="Khulna";
        s.setLocation(Location);
    }

    @Test
    public void TestSetGender() {
        String Gender= "Male";
        s.setGender(Gender);
    }
}