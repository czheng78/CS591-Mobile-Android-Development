package com.example.tz1993.temp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final String MyFlag = "PWD_FLAG";  //this will be our trail of breadcrumbs for logging events.
    private static int eventCount = 0;

    private Button btn;
    private EditText edtxt;
    private TextView txtV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onCreate State Transition");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        edtxt = (EditText) findViewById(R.id.edtxt);
        txtV = (TextView) findViewById(R.id.txtV);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtxt.setText("Hello");
                txtV.setText("Hello");
            }
        });
    }

    @Override
    protected void onPause() {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onPause State Transition");
        super.onPause();
    }


    @Override
    protected void onStart() {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onStart State Transition");
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onSaveInstanceState State Transition");
        Log.i(MyFlag, "Bundling State of our views before they get destroyed");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onRestoreInstanceState State Transition");
        Log.i(MyFlag, "Retrieving our saved state from before... ");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onRestoreInstanceState State Transition");
        super.onResume();
    }

    @Override
    protected void onStop() {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onStop State Transition");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onDestroy State Transition");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onRestart State Transition");
        super.onRestart();
    }

    //Handy Helpers...
    public String intToStr(Integer i)
    {
        return i.toString();
    }

    public int strToInt(String S)
    {
        return Integer.parseInt(S);
    }
}
