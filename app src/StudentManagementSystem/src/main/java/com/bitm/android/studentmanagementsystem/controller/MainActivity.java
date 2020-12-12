package com.bitm.android.studentmanagementsystem.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.bitm.android.studentmanagementsystem.R;

public class MainActivity extends AppCompatActivity {
    private StudentPreference studentPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentPreference = new StudentPreference(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_settings:

                break;

            case R.id.item_logout:
                studentPreference.setLoginStatus(false);
                Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.loginFragment);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

