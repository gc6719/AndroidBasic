package com.utils.rekha.myuisample.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Gururaj on 4/29/2018.
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    List<String> mfragmentName;
    HashMap<String, Fragment> mList;

    public void addFragmentToList(String title, Fragment fragment) {
        mfragmentName.add(title);
        mList.put(title, fragment);
    }

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mfragmentName = new ArrayList<>();
        mList = new HashMap<>();
    }


    @Override
    public Fragment getItem(int position) {
        String name = mfragmentName.get(position);
        Fragment fragment = mList.get(name);
        return fragment;
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }
}
