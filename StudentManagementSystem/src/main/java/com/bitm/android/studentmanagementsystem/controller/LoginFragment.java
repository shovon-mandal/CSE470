package com.bitm.android.studentmanagementsystem.controller;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bitm.android.studentmanagementsystem.R;

public class LoginFragment extends Fragment {
    private EditText emailET, passET;
    private Button loginBtn;
    private StudentPreference studentPreference;

    public LoginFragment() {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        studentPreference = new StudentPreference(context);
        if (studentPreference.getLoginStatus()) {
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_loginFragment_to_dashboardFragment);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        emailET = view.findViewById(R.id.emailInput);
        passET = view.findViewById(R.id.passwordInput);
        loginBtn = view.findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailET.getText().toString();
                String password = passET.getText().toString();


                if (email.isEmpty()){
                    emailET.setError("Please Provide Email");
                    return;
                }
                if (password.isEmpty()){
                    passET.setError("Please Provide Valid Name");
                    return;
                }



                if(email.equals("admin") && password.equals("admin")) {

                    studentPreference.setLoginStatus(true);
                    Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_dashboardFragment);
                    Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
                }

                else if(email.equals("user") && password.equals("1234")) {

                    studentPreference.setLoginStatus(true);
                    Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_studentDashboard);
                    Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
                }

                else{
                    studentPreference.setLoginStatus(false);
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

