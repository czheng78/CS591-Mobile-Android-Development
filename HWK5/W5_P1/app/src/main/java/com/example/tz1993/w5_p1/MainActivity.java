package com.example.tz1993.w5_p1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ControlFragment.ControlFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendMessage(String msg) {
        BottomFragment receiveFrag = (BottomFragment) getSupportFragmentManager().findFragmentById(R.id.fgImage);
        receiveFrag.setMessage(msg);
    }

    @Override
    public void changeBG(int pos) {
        BottomFragment receiveFrag2 = (BottomFragment) getSupportFragmentManager().findFragmentById(R.id.fgImage);
        switch (pos) {
            case 0:
                receiveFrag2.getView().setBackgroundResource(R.drawable.squareburger);
                break;
            case 1:
                receiveFrag2.getView().setBackgroundResource(R.drawable.frenchtoast);
                break;
            case 2:
                receiveFrag2.getView().setBackgroundResource(R.drawable.kbbq);
                break;
            case 3:
                receiveFrag2.getView().setBackgroundResource(R.drawable.nachos);
                break;
            case 4:
                receiveFrag2.getView().setBackgroundResource(R.drawable.salsal);
                break;
        }
    }
}
