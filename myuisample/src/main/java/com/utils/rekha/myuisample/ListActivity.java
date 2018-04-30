package com.utils.rekha.myuisample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    List<Student> studentList = new ArrayList<>();
    StudentAdapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = (RecyclerView) findViewById(R.id.mylist);
        studentList = getDataForStudent();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentAdapter(studentList,this) ;
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }



    private List<Student> getDataForStudent(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(R.mipmap.ic_launcher_round , "Stud1" , "dd-mm-yy"));
        studentList.add(new Student(R.mipmap.ic_launcher_round , "Stud2" , "dd-mm-yy"));
        studentList.add(new Student(R.mipmap.ic_launcher_round , "Stud3" , "dd-mm-yy"));
        studentList.add(new Student(R.mipmap.ic_launcher_round , "Stud4" , "dd-mm-yy"));
        return studentList;
    }
}
