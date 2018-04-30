package com.utils.rekha.myuisample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SecondFragment extends Fragment {

    View view;
    Button btn_sec_back , btn_sec_next ;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private OnSecondFragmentInterface mListener;

    public SecondFragment() {

    }

    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,   Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_second, container, false);
        initView();
        clickHandler();
        return view ;

    }

    private void initView(){
        btn_sec_back = (Button)view.findViewById(R.id.btn_sec_back);
        btn_sec_next = (Button)view.findViewById(R.id.btn_sec_next);
    }


    private void clickHandler()
    {
        btn_sec_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onSecondFragBackPressed();
            }
        });


        btn_sec_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.onSecondFragNextPressed();
            }
        });
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSecondFragmentInterface) {
            mListener = (OnSecondFragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSecondFragmentInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnSecondFragmentInterface {
        void onSecondFragBackPressed( );
        void onSecondFragNextPressed( );

    }
}
