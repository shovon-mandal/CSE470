package com.bitm.android.studentmanagementsystem.controller;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.bitm.android.studentmanagementsystem.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class DashboardFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule= new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity=null;


    @Before
    public void setUp() throws Exception {
        mActivity=mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        View v= mActivity.findViewById(R.id.dasBD);
        assertNotNull(v);
    }



    @After
    public void tearDown() throws Exception {
        mActivity=null;
    }
}