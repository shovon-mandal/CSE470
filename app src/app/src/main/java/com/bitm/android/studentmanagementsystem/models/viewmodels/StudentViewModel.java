package com.bitm.android.studentmanagementsystem.models.viewmodels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.bitm.android.studentmanagementsystem.models.Student;
import com.bitm.android.studentmanagementsystem.models.db.StudentDatabase;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    private final String TAG = StudentViewModel.class.getSimpleName();
    private MutableLiveData<List<Student>> StudentList = new MutableLiveData<>();
    private MutableLiveData<Student> employeeMutableLiveData = new MutableLiveData<>();
    private Context context;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }

    public MutableLiveData<List<Student>> getAllStudent() {
        StudentList.postValue(StudentDatabase.getDb(context).getStudentDao().getAllStudents());
        return StudentList;
    }

    public void addNewStudent(Student student) {

        StudentDatabase.getDb(context)
                .getStudentDao()
                .insertNewStudent(student);
    }

    public MutableLiveData<Student> getSingleStudent(long id) {
        employeeMutableLiveData.postValue(StudentDatabase.getDb(context).getStudentDao().getStudentById(id));
        return employeeMutableLiveData;
    }

    public void delete(Student student) {
        StudentDatabase.getDb(context)
                .getStudentDao()
                .deleteStudent(student);
    }

    public void update(Student student) {
        StudentDatabase.getDb(context)
                .getStudentDao()
                .updateStudent(student);
    }
}
