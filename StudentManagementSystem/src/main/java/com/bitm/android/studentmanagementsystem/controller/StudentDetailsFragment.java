package com.bitm.android.studentmanagementsystem.controller;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bitm.android.studentmanagementsystem.R;
import com.bitm.android.studentmanagementsystem.models.Student;
import com.bitm.android.studentmanagementsystem.view.StudentViewModel;

public class StudentDetailsFragment extends Fragment {
    private static final String TAG = StudentDetailsFragment.class.getSimpleName();
    private TextView nameTV, depTV, desTV, dobTV, hobbyTV;
    private StudentViewModel studentViewModel;
    public StudentDetailsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        studentViewModel = new ViewModelProvider(requireActivity()).get(StudentViewModel.class);
        return inflater.inflate(R.layout.fragment_student_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        final long id = getArguments().getLong("id");
        studentViewModel.getSingleStudent(id)
                .observe(getViewLifecycleOwner(), new Observer<Student>() {
                    @Override
                    public void onChanged(Student student) {
                        nameTV.setText(student.getName());
                        depTV.setText(student.getDepartment());
                        desTV.setText(student.gCGPA());
                        //cgpaTV.setText((int) student.getCGPA());
                        dobTV.setText(student.getDob());
                        hobbyTV.setText(student.getHobby());
                        Log.e(TAG, student.toString());
                    }
                });
    }

    private void initViews(View view) {
        nameTV = view.findViewById(R.id.details_emp_name);
        depTV = view.findViewById(R.id.details_emp_department);
        desTV = view.findViewById(R.id.details_emp_designation);
        dobTV = view.findViewById(R.id.details_emp_dob);
        hobbyTV = view.findViewById(R.id.details_emp_allowance);
    }


}