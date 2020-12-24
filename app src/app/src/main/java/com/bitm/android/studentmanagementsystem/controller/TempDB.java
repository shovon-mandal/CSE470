package com.bitm.android.studentmanagementsystem.controller;

import com.bitm.android.studentmanagementsystem.models.Student;

import java.util.ArrayList;

public class TempDB {

    public static ArrayList<String> departments;
    public static ArrayList<String> qualification;
    public static ArrayList<String> jobLocations;
    public static ArrayList<Student> studentArrayList;

    static {
        departments = new ArrayList<>();
        qualification = new ArrayList<>();
        jobLocations = new ArrayList<>();
        studentArrayList = new ArrayList<>();
        populateDepartments();
        populateDesingnations();
        populateLocations();

    }



    private static void populateDepartments() {
        departments.add("CSE");
        departments.add("EEE");
        departments.add("ECE");
        departments.add("BBS");
        departments.add("MNS");
        departments.add("Arch");
    }

    private static void populateDesingnations() {
        qualification.add("HSC");
        qualification.add("O'Level");
        qualification.add("Other");

    }

    private static void populateLocations() {
        jobLocations.add("Dhaka");
        jobLocations.add("Chittagong");
        jobLocations.add("Rajshahi");
        jobLocations.add("Khulna");
        jobLocations.add("Barishal");
        jobLocations.add("Sylhet");
        jobLocations.add("Rangpur");
    }
}
