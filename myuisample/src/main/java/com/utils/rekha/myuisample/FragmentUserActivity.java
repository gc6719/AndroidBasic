package com.utils.rekha.myuisample;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class FragmentUserActivity extends AppCompatActivity implements
        FirstFragment.OnFirstFragmentInterface ,SecondFragment.OnSecondFragmentInterface ,
        ThirdFragment.OnThirdFragmentInterface {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_user);

        Fragment fragment = FirstFragment.newInstance("","");

        getSupportFragmentManager().beginTransaction()
                .add(R.id.root_fragment_container ,fragment , FirstFragment.class.getSimpleName())
                .addToBackStack(FirstFragment.class.getSimpleName())
                .commit();
    }


    // ADD SECOND FRAGMENT
    private void addSecondFrag(){
        SecondFragment fragment = SecondFragment.newInstance("","") ;
        getSupportFragmentManager().beginTransaction()
                .add(R.id.root_fragment_container,fragment , SecondFragment.class.getSimpleName())
                .addToBackStack(SecondFragment.class.getSimpleName())
                .commit();
    }

    private void addThirdFrag(){
        ThirdFragment fragment = ThirdFragment.newInstance("","") ;
        getSupportFragmentManager().beginTransaction()
                .add(R.id.root_fragment_container,fragment , ThirdFragment.class.getSimpleName())
                .addToBackStack(ThirdFragment.class.getSimpleName())
                .commit();
    }



    // FIRST FRAGMENT METHODS
    @Override
    public void onFirstFragmentCallBack( ) {
        addSecondFrag();
    }



    // SECOND FRAGMENT
    @Override
    public void onSecondFragBackPressed() {
        getSupportFragmentManager().popBackStackImmediate();
    }

    @Override
    public void onSecondFragNextPressed() {
        addThirdFrag();
    }
    // SECOND FRAGMENT



    /// 3RD FRAGMENT
    @Override
    public void onThirdFragBackPressed() {
        getSupportFragmentManager().popBackStackImmediate();
    }

    @Override
    public void onThirdFragNextPressed() {

    }

    /// 3RD FRAGMENT
}
