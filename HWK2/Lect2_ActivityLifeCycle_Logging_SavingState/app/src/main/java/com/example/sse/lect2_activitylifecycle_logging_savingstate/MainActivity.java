package com.example.sse.lect2_activitylifecycle_logging_savingstate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private static final String MyFlag = "LECT2_FLAG";  //this will be our trail of breadcrumbs for logging events.
    private static int eventCount = 0;


    private Button btnCtoF;
    private EditText txtC;
    private EditText txtF;
    private Button btnFtoC;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onCreate State Transition");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//Let's find our view references

        btnCtoF = (Button) findViewById(R.id.btnCtoF);
        txtC = (EditText) findViewById(R.id.txtC);
        txtF = (EditText) findViewById(R.id.txtF);
        btnFtoC = (Button) findViewById(R.id.btnFtoC);

        btnCtoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String C, F;
                Double DegC, DegF;

                C = txtC.getText().toString();
                DegC = Double.parseDouble(C);
                DegF = DegC*9.0/5.0 + 32;   //todo, dblcheck formula.
                F = DegF.toString();
                txtF.setText(F);

            }
        })

        btnFtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String C, F;
                Double DegC, DegF;

                F = txtF.getText().toString();
                DegF = Double.parseDouble(F);
                DegC = (DegF-32)*5.0/9.0;
                C = DegC.toString();
                txtC.setText(C);
            }
        });


    }

    //Useful Notes:
        // ctrl-O is a shortcut to override base methods
        // Alt-Ins is a shortcut to overriding base methods and more.

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

