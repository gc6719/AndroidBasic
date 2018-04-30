package com.utils.rekha.myuisample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Gururaj on 4/15/2018.
 */

public class StudentViewHolder extends RecyclerView.ViewHolder {
    ImageView stud_img ;
    TextView stud_name , stud_dob ;
    public StudentViewHolder(View itemView) {
        super(itemView);
        stud_img = (ImageView)itemView.findViewById(R.id.stud_img);
        stud_name = (TextView) itemView.findViewById(R.id.stud_name);
        stud_dob = (TextView)itemView.findViewById(R.id.stud_dob);

    }
}
