package com.example.wangchunxi.c9_p23;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TopFrag.TopCallbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendTrans(int progress) {
        FragmentManager fm = getSupportFragmentManager();
        BottomFrag bFrag = (BottomFrag) fm.findFragmentById(R.id.bottom);
        bFrag.setTrans(progress);
    }
}
