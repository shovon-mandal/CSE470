package com.bitm.android.studentmanagementsystem.controller;

import android.view.View;
import android.widget.RelativeLayout;

import androidx.test.rule.ActivityTestRule;

import com.bitm.android.studentmanagementsystem.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LoginFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity>mActivityTestRule= new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity=null;


    @Before
    public void setUp() throws Exception {
        mActivity=mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        RelativeLayout rlContainer = (RelativeLayout) mActivity.findViewById((R.id.nav_host_fragment));
        assertNotNull(rlContainer);
        LoginFragment f= new LoginFragment();
        mActivity.getFragmentManager().beginTransaction().add(rlContainer.getId(),null).commitAllowingStateLoss();
        View v=f.getView().findViewById(R.id.action_loginFragment_to_studentDashboard);
        assertNotNull(v);
    }



    @After
    public void tearDown() throws Exception {
        mActivity=null;
    }
}