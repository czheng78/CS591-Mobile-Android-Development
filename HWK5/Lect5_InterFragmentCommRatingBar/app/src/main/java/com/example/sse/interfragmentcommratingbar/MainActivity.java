package com.example.sse.interfragmentcommratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentButton.PictureChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("checking", "stop000");
    }
    public void changePicture(int currDrawableIndex){
        DrawableFragment drawableFragment = (DrawableFragment)getSupportFragmentManager().findFragmentById(R.id.fragment);
        drawableFragment.changePicture(currDrawableIndex);
    }
    public void saveRate(int currDrawableIndex){
        DrawableFragment drawableFragment = (DrawableFragment)getSupportFragmentManager().findFragmentById(R.id.fragment);
        drawableFragment.saveRate(currDrawableIndex);
    }
}
