package com.bitm.android.studentmanagementsystem.models.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.bitm.android.studentmanagementsystem.models.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    long insertNewStudent(Student student);

    @Update
    void updateStudent(Student student);

    @Delete
    void deleteStudent(Student student);

    @Query("select * from tbl_stu")
    List<Student> getAllStudents();

    @Query("select * from tbl_stu where id like :id")
    Student getStudentById(long id);
}
