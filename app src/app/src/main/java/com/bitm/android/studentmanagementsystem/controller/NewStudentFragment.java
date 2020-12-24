package com.bitm.android.studentmanagementsystem.controller;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.bitm.android.studentmanagementsystem.R;
import com.bitm.android.studentmanagementsystem.models.Student;
import com.bitm.android.studentmanagementsystem.models.viewmodels.StudentViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class NewStudentFragment extends Fragment {
    private StudentViewModel studentViewModel;
    private final String TAG = "NewStudentFragment";
    private Spinner departmentSP, designationSP, locationSP;
    private TextInputEditText nameET, ageET, phoneET, emailET, salaryET;
    private RadioGroup genderRG;
    private Button dobBtn, saveBtn;
    private CheckBox musicCB, sportCB, travelCB, gamingCB, danceCB, othersCB;
    private String gender = "Male", dob, department, designation, location;
    private List<String> allowances = new ArrayList<>();
    private long empID = 0;
    public NewStudentFragment() {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        studentViewModel = new ViewModelProvider(requireActivity()).get(StudentViewModel.class);
        return inflater.inflate(R.layout.fragment_new_student, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        final Bundle bundle = getArguments();
        if (bundle != null) {
            saveBtn.setText("Update");
            empID = bundle.getLong("id");
            studentViewModel.getSingleStudent(empID).observe(getViewLifecycleOwner(), new Observer<Student>() {
                @Override
                public void onChanged(Student student) {

                    String name = nameET.getText().toString();



                    nameET.setText(student.getName());
                    ageET.setText(String.valueOf(student.getAge()));
                    phoneET.setText(student.getMobile());
                    emailET.setText(student.getEmailAddress());
                    salaryET.setText(String.valueOf(student.getCGPA()));
                    dobBtn.setText(student.getDob());
                    if (student.getGender().equals("Female")) {
                        genderRG.check(R.id.femaleRB);
                    }
                    departmentSP.setSelection(TempDB.departments.indexOf(student.getDepartment()));
                    designationSP.setSelection(TempDB.qualification.indexOf(student.getQualification()));
                    locationSP.setSelection(TempDB.jobLocations.indexOf(student.getLocation()));
                    String allowances = student.getHobby();
                    List<String> allowanceList = Arrays.asList(allowances.split(","));
                    for (String s : allowanceList) {
                        Log.e("Allowances", s);
                    }
                    for (String s : allowanceList) {
                        setAllownaceOnCheckbox(s);
                    }

                }
            });
        }
        musicCB.setOnClickListener(checkboxClickListener);
        sportCB.setOnClickListener(checkboxClickListener);
        travelCB.setOnClickListener(checkboxClickListener);
        gamingCB.setOnClickListener(checkboxClickListener);
        danceCB.setOnClickListener(checkboxClickListener);
        othersCB.setOnClickListener(checkboxClickListener);

        ArrayAdapter<String> depAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, TempDB.departments);
        ArrayAdapter<String> desgAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, TempDB.qualification);
        ArrayAdapter<String> locAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, TempDB.jobLocations);

        departmentSP.setAdapter(depAdapter);
        designationSP.setAdapter(desgAdapter);
        locationSP.setAdapter(locAdapter);

        dobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        formatDate(year, month, dayOfMonth);

                    }
                }, 2000, 0, 1);
                datePickerDialog.show();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = nameET.getText().toString();

                if (name.isEmpty()){
                    nameET.setError("Please Provide Valid Name");
                    return;
                }


                final String age = ageET.getText().toString();
                if (age.isEmpty()){
                    ageET.setError("Please Provide Valid age");
                    return;
                }
                final String mobile = phoneET.getText().toString();
                if (mobile.isEmpty()){
                    phoneET.setError("Please Provide Valid mobile number");
                    return;
                }

                final String email = emailET.getText().toString();

                if (email.isEmpty()){
                    emailET.setError("Please Provide Valid email");
                    return;
                }

                final String salary = salaryET.getText().toString();

                if (salary.isEmpty()){
                    salaryET.setError("Please Provide Valid salary");
                    return;
                }

                String allowanceString = TextUtils.join(",", allowances);

                final Student student = new Student(name, Integer.parseInt(age), mobile, email, Double.parseDouble(salary),
                        gender, dob, department, designation, location, allowanceString);
                Log.e(TAG, "onClick: "+ student);

                if (empID > 0) {
                    student.setId(empID);
                    studentViewModel.update(student);
                }else {
                    studentViewModel.addNewStudent(student);
                }
                Navigation.findNavController(v).navigate(R.id.dashboardFragment);

                Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();





            }
        });

        genderRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                final RadioButton rb = view.findViewById(checkedId);
                gender = rb.getText().toString();
            }
        });

        departmentSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                department = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        designationSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                designation = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        locationSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                location = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void setAllownaceOnCheckbox(String s) {
        switch (s) {
            case "Music":
                musicCB.setChecked(true);
                break;
            case "Sport":
                sportCB.setChecked(true);
                break;
            case "Travel":
                travelCB.setChecked(true);
                break;
            case "Gaming":
                gamingCB.setChecked(true);
                break;
            case "Dance":
                danceCB.setChecked(true);
                break;
            case "Others":
                othersCB.setChecked(true);
                break;

        }
    }

    private void formatDate(int year, int month, int dayOfMonth) {
        final SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd, yyyy");
        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        dob = sdf.format(calendar.getTime());
        dobBtn.setText(dob);
    }

    private void initViews(View view) {
        departmentSP = view.findViewById(R.id.departmentSpinner);
        designationSP = view.findViewById(R.id.designationSpinner);
        locationSP = view.findViewById(R.id.locationSpinner);

        nameET = view.findViewById(R.id.nameInput);
        ageET = view.findViewById(R.id.ageInput);
        emailET = view.findViewById(R.id.emailInput);
        phoneET = view.findViewById(R.id.phoneInput);
        salaryET = view.findViewById(R.id.salaryInput);

        genderRG = view.findViewById(R.id.genderRadioGroup);

        saveBtn = view.findViewById(R.id.saveEmployeeBtn);
        dobBtn = view.findViewById(R.id.dobBtn);

        musicCB = view.findViewById(R.id.foodCB);
        sportCB = view.findViewById(R.id.medicalCB);
        travelCB = view.findViewById(R.id.transportCB);
        gamingCB = view.findViewById(R.id.phoneCB);
        danceCB = view.findViewById(R.id.houseRentCB);
        othersCB = view.findViewById(R.id.othersCB);
    }

    private View.OnClickListener checkboxClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            final CheckBox cb = (CheckBox) v;
            final String allowance = cb.getText().toString();
            if (cb.isChecked()) {
                allowances.add(allowance);
            }else{
                allowances.remove(allowance);
            }
        }
    };
}