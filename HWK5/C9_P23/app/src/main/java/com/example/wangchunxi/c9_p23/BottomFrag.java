package com.example.wangchunxi.c9_p23;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFrag extends Fragment {
    private TextView tv;

    public BottomFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View fragmentView = getView();
        tv = fragmentView.findViewById(R.id.textView);
        tv.getBackground().setAlpha(0);
    }

    public void setTrans(int progress){
        tv.getBackground().setAlpha(progress);
    }
}
