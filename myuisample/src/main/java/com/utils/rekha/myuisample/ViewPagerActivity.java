package com.utils.rekha.myuisample;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.utils.rekha.myuisample.adapter.MyViewPagerAdapter;

public class ViewPagerActivity extends AppCompatActivity implements
        FirstFragment.OnFirstFragmentInterface ,SecondFragment.OnSecondFragmentInterface ,
        ThirdFragment.OnThirdFragmentInterface{

    MyViewPagerAdapter pagerAdapter ;
    ViewPager view_container ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initView();
        pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        addFragmentToList();
    }


    private void addFragmentToList(){
        pagerAdapter.addFragmentToList("First", new FirstFragment());
        pagerAdapter.addFragmentToList("Second", new SecondFragment ( ));
        pagerAdapter.addFragmentToList("Third", new ThirdFragment ( ));
        view_container.setAdapter(pagerAdapter);
    }

    private void initView(){
        view_container = (ViewPager)findViewById(R.id.view_container);

    }

    // FIRST FRAGMENT METHODS
    @Override
    public void onFirstFragmentCallBack( ) {
       if(view_container != null){
           view_container.setCurrentItem(1,true);
       }
    }



    // SECOND FRAGMENT
    @Override
    public void onSecondFragBackPressed() {
        if(view_container != null){
            view_container.setCurrentItem(0,true);
        }
    }

    @Override
    public void onSecondFragNextPressed() {
        if(view_container != null){
            view_container.setCurrentItem(2,true);
        }
    }
    // SECOND FRAGMENT



    /// 3RD FRAGMENT
    @Override
    public void onThirdFragBackPressed() {
        if(view_container != null){
            view_container.setCurrentItem(1,true);
        }
    }

    @Override
    public void onThirdFragNextPressed() {

        Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
    }

}
