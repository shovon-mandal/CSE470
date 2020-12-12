package com.bitm.android.studentmanagementsystem.models.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.bitm.android.studentmanagementsystem.models.Student;
import com.bitm.android.studentmanagementsystem.models.daos.StudentDao;

@Database(entities = {Student.class}, version = 2)
public abstract class StudentDatabase extends RoomDatabase {
    public abstract StudentDao getStudentDao();
    private static StudentDatabase db;

    private final static Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("begin transaction");

        }
    };

    public static StudentDatabase getDb(Context context) {
        //Singleton Pattern
        if (db != null) {
            return db;
        }

        db = Room.databaseBuilder(context, StudentDatabase.class, "stu_db")
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2)
                .build();
        return db;
    }
}
