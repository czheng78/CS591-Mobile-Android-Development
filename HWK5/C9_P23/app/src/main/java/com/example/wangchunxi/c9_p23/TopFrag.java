package com.example.wangchunxi.c9_p23;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFrag extends Fragment {
    private TopCallbacks tCallback = tDummyCallback;

    public TopFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View fragmentView = getView();
        SeekBar sb = (SeekBar) fragmentView.findViewById(R.id.seekBar);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tCallback.sendTrans(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            tCallback = (TopCallbacks) context;
        }catch(Exception e) {
            Log.i("!!!","onAttach");
            e.printStackTrace();
            return;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        tCallback = tDummyCallback;
    }

    public interface TopCallbacks{
        public void sendTrans(int progress);
    }

    private static TopCallbacks tDummyCallback = new TopCallbacks() {
        @Override
        public void sendTrans(int progress) {

        }
    };

}
