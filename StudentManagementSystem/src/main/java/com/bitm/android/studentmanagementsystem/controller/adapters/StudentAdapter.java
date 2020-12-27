package com.bitm.android.studentmanagementsystem.controller.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bitm.android.studentmanagementsystem.R;
import com.bitm.android.studentmanagementsystem.models.Student;

import java.util.List;

/*
* 1. Layout Inflate (row layout)
* 2. View Initialize
* 3. Data Set
* */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentVeiwHolder> {

    private static final String TAG = "StudentAdapter";
    private Context context;
    private List<Student> studentList;
    private int count = 0;
    private OnStudentEditDeleteListener listener;

    public StudentAdapter(Context context, List<Student> studentList, Fragment fragment) {
        this.context = context;
        this.studentList = studentList;
        listener = (OnStudentEditDeleteListener) fragment;
    }

    @NonNull
    @Override
    public StudentVeiwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        count++;
        Log.e(TAG, "onCreateViewHolder called "+count+" times");
        View itemView = LayoutInflater.from(context).inflate(R.layout.student_row, parent, false);
        return new StudentVeiwHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentVeiwHolder holder, final int position) {
        holder.nameTV.setText(studentList.get(position).getName());
        holder.depTV.setText(studentList.get(position).getDepartment());
        holder.phoneTV.setText(studentList.get(position).getMobile());
        holder.menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.getMenuInflater().inflate(R.menu.emp_row_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_edit:
                                final Bundle bundle = new Bundle();
                                bundle.putLong("id", studentList.get(position).getId());
                                Navigation.findNavController(v).navigate(R.id.action_employeeListFragment_to_newEmployeeFragment, bundle);
                                break;
                            case R.id.item_delete:
                                showAlertDialog(position);
                                break;
                        }
                        return false;
                    }
                });
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final long empId = studentList.get(position).getId();
                final Bundle bundle = new Bundle();
                bundle.putLong("id", empId);
                Navigation.findNavController(v).navigate(R.id.action_employeeListFragment_to_employeeDetailsFragment, bundle);
            }
        });
    }

    private void showAlertDialog(final int position) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.ic_baseline_delete_forever_24);
        builder.setTitle("Delete "+ studentList.get(position).getName());
        builder.setMessage("Are you sure to delete this employee?");
        builder.setNegativeButton("No", null);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onDelete(studentList.get(position));
            }
        });
        final AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class StudentVeiwHolder extends RecyclerView.ViewHolder {
        ImageView empIV;
        TextView nameTV, depTV, phoneTV;
        Button menuBtn;
        public StudentVeiwHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.row_emp_name);
            depTV = itemView.findViewById(R.id.row_emp_dept);
            phoneTV = itemView.findViewById(R.id.row_emp_mobile);
            menuBtn = itemView.findViewById(R.id.row_emp_menu);
            empIV = itemView.findViewById(R.id.row_emp_image);


        }
    }

    public interface OnStudentEditDeleteListener {
        void onEdit(Student student);
        void onDelete(Student student);
    }

    public void refresh(Student student) {
        studentList.remove(student);
        notifyDataSetChanged();
    }
}
