package com.utils.rekha.myuisample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class FirstFragment extends Fragment {
    View view ;
    Button click_me ;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFirstFragmentInterface mListener;
    public FirstFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_first, container, false);

        initView();
        click_me = (Button)view.findViewById(R.id.click_me) ;
        click_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFirstFragmentCallBack();
            }
        });

        // Set Layout Status
        setLayoutEnabled(swt_main.isChecked());
        swt_main.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setLayoutEnabled(buttonView.isChecked());
            }
        });

        // Set Notification view
        setNotificationOption(radio_auto.isChecked());
        radio_grp_notiofy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                setNotificationOption (checkedId == radio_auto.getId()) ;
            }
        });

        img_auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Auto setting",Toast.LENGTH_SHORT).show();
            }
        });

        img_manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Manual setting",Toast.LENGTH_SHORT).show();
            }
        });

        return view ;

    }

    Switch swt_main, swt_switch_two, swt_switch_three;
    TextView txt_switch_two, txt_switch_three, txt_swt_status;
    RadioGroup radio_grp_notiofy;
    RadioButton radio_auto, radio_manual;
    ImageView img_auto, img_manual;

    void initView() {

        //Notification Radio Group
        radio_auto = (RadioButton) view.findViewById(R.id.radio_auto);
        radio_manual = (RadioButton) view.findViewById(R.id.radio_manual);
        radio_grp_notiofy = (RadioGroup) view.findViewById(R.id.radio_grp_notiofy);
        img_auto = (ImageView) view.findViewById(R.id.img_auto);
        img_manual = (ImageView) view.findViewById(R.id.img_manual);

        //Main Switch View
        swt_main = (Switch) view.findViewById(R.id.swt_main);
        txt_swt_status = (TextView) view.findViewById(R.id.txt_swt_status);


        txt_switch_two = (TextView) view.findViewById(R.id.txt_switch_two);
        swt_switch_two = (Switch) view.findViewById(R.id.swt_switch_two);

        txt_switch_three = (TextView) view.findViewById(R.id.txt_switch_three);
        swt_switch_three = (Switch) view.findViewById(R.id.swt_switch_three);
    }


    void setNotificationOption(boolean isAuto) {
        img_auto.setEnabled(isAuto);
        img_manual .setEnabled(!isAuto);
        img_auto.setBackgroundColor(ContextCompat.getColor(getActivity().getApplicationContext(), isAuto ? R.color.text_color : R.color.text_color_disabled));
        img_manual.setBackgroundColor(ContextCompat.getColor(getActivity().getApplicationContext(), isAuto ? R.color.text_color_disabled : R.color.text_color));

    }


    void setLayoutEnabled(boolean isEnabled) {
        txt_swt_status.setText(isEnabled ? "No" : "Off");
        txt_switch_two.setEnabled(isEnabled);
        txt_switch_three.setEnabled(isEnabled);
        swt_switch_two.setEnabled(isEnabled);
        swt_switch_three.setEnabled(isEnabled);

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFirstFragmentInterface) {
            mListener = (OnFirstFragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()+ " must implement OnFirstFragmentInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFirstFragmentInterface {
        void onFirstFragmentCallBack( );
    }
}
