package com.example.tz1993.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    private static final String MyFlag = "PWD_FLAG";  //this will be our trail of breadcrumbs for logging events.
    private static int eventCount = 0;

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button btnPlus;
    private Button btnMult;
    private Button btnSqrt;
    private Button btnMinus;
    private Button btnDiv;
    private Button btnEq;
    private Button btn10;
    private TextView result;

    double value1, value2;

    boolean Addition, Subtraction, Division, Multiplication, Sqrt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        eventCount++;
        Log.i(MyFlag, intToStr(eventCount) + ": Activity onCreate State Transition");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnSqrt = (Button) findViewById(R.id.btnSqrt);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnEq = (Button) findViewById(R.id.btnEq);
        btn10 = (Button) findViewById(R.id.btn10);

        result = (TextView) findViewById(R.id.result);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result == null) {
                    result.setText("");
                } else {
                    value1 = Float.parseFloat(result.getText() + "");
                    Addition = true;
                    result.setText(null);
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = Float.parseFloat(result.getText() + "");
                Subtraction = true;
                result.setText(null);
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = Float.parseFloat(result.getText() + "");
                Multiplication = true;
                result.setText(null);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = Float.parseFloat(result.getText() + "");
                Division = true;
                result.setText(null);
            }
        });

        btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = Float.parseFloat(result.getText() + "");
                Sqrt = true;
                result.setText((int) sqrt(value1) + "");
                Sqrt = false;
            }
        });

        btnEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value2 = Float.parseFloat(result.getText() + "");

                if (Addition == true) {
                    result.setText(value1 + value2 + "");
                    Addition = false;
                }

                if (Subtraction == true) {
                    result.setText(value1 - value2 + "");
                    Subtraction = false;
                }

                if (Multiplication == true) {
                    result.setText(value1 * value2 + "");
                    Multiplication = false;
                }

                if (Division == true) {
                    result.setText(value1 / value2 + "");
                    Division = false;
                }
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + ".");
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
