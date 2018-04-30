package com.utils.rekha.myuisample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Gururaj on 4/15/2018.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {

    List<Student> studentList ;
    Context context ;

    public StudentAdapter(List<Student> studentList , Context context)
    {
        this.studentList = studentList;
        this.context = context ;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext()) ;
           View view = layoutInflater. inflate(R.layout.student_row_view,parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {

        holder.stud_img.setImageDrawable( context.getResources().
                getDrawable(studentList.get(position).getImage()));

        holder.stud_name.setText(studentList.get(position).getName());
        holder.stud_dob.setText(studentList.get(position).getDob());

    }

    @Override
    public int getItemCount() {
       /* if(studentList !=null){
            return  studentList.size();
        }else
            return  0 ;
        */
        return  studentList !=null ?studentList.size() : 0;
        /*

        condition ? 1st part : 2nd part ;

        */
    }



}
