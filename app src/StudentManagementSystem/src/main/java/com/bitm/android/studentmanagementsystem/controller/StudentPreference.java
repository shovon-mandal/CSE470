package com.bitm.android.studentmanagementsystem.controller;

import android.content.Context;
import android.content.SharedPreferences;

public class StudentPreference {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private final String IS_LOGGED_IN = "isLoggedIn";

    public StudentPreference(Context context) {
        sharedPreferences = context.getSharedPreferences("stu_prefs", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setLoginStatus(boolean status) {
        editor.putBoolean(IS_LOGGED_IN, status);
        editor.commit();//save
    }

    public boolean getLoginStatus() {
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }
}
