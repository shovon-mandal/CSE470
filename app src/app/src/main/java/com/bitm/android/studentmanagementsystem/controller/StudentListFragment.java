package com.bitm.android.studentmanagementsystem.controller;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bitm.android.studentmanagementsystem.R;
import com.bitm.android.studentmanagementsystem.controller.adapters.StudentAdapter;
import com.bitm.android.studentmanagementsystem.models.Student;
import com.bitm.android.studentmanagementsystem.models.viewmodels.StudentViewModel;

import java.util.List;

public class StudentListFragment extends Fragment implements StudentAdapter.OnStudentEditDeleteListener {
    private RecyclerView employeeRecyclerView;
    private StudentAdapter studentAdapter;
    private StudentViewModel studentViewModel;
    private ImageView emptyListIV;

    public StudentListFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        studentViewModel = new ViewModelProvider(requireActivity()).get(StudentViewModel.class);
        return inflater.inflate(R.layout.fragment_student_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        employeeRecyclerView = view.findViewById(R.id.employeeRV);
        emptyListIV = view.findViewById(R.id.emptyListIV);
        studentViewModel.getAllStudent().observe(getViewLifecycleOwner(), new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> studentList) {
                if (studentList.size() == 0) {
                    emptyListIV.setVisibility(View.VISIBLE);
                }
                studentAdapter = new StudentAdapter(getActivity(), studentList, StudentListFragment.this);
                LinearLayoutManager llm = new LinearLayoutManager(getActivity());


                GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
                employeeRecyclerView.setLayoutManager(llm);
                employeeRecyclerView.setAdapter(studentAdapter);
            }
        });
    }


    @Override
    public void onEdit(Student student) {

    }

    @Override
    public void onDelete(Student student) {
        studentViewModel.delete(student);
        studentAdapter.refresh(student);
        Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
    }
}