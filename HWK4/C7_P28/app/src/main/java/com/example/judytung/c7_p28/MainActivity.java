package com.example.judytung.c7_p28;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity{

    public static int STATUS_BAR_HEIGHT = 24;
    public static int ACTION_BAR_HEIGHT = 56;
    private TextView txt_fling;
    RelativeLayout rl;
    private RelativeLayout.LayoutParams params;
    private GestureDetector ges_detec;
    int windowWidth;
    int windowHeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildGuiByCode();



        ges_detec = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                Log.i("check", "down");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                Log.i("check", "show press");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                Log.i("check", "single tap");
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                Log.i("check", "scroll");


                int Y = (int)(motionEvent1.getRawY()- motionEvent.getRawY());
                int X = (int)(motionEvent1.getRawX()- motionEvent.getRawX());
//                int Y = (int)(motionEvent1.getRawY());
//                int X = (int)(motionEvent1.getRawX());
                params.leftMargin = X;
                params.topMargin = Y;

                txt_fling.setLayoutParams(params);

                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                Log.i("check", "long press");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                Log.i("check", "fling");
                //Log.w("startx",String.valueOf(v1));
                if (Math.abs(v1) < 4000){
                    int Y = (int)(motionEvent1.getRawY()- motionEvent.getRawY());
                    int X = (int)(motionEvent1.getRawX()- motionEvent.getRawX());
                    params.leftMargin = X;
                    params.topMargin = Y;
                    txt_fling.setLayoutParams(params);
                }
                else{
                    Log.i("check", "random!");
//                    DisplayMetrics displayMetrics = new DisplayMetrics();
//                    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//                    int height = displayMetrics.heightPixels;
//                    int width = displayMetrics.widthPixels;
                    Point size = new Point();
                    getWindowManager().getDefaultDisplay().getSize(size);

                    Resources res = getResources();
                    DisplayMetrics metrics = res.getDisplayMetrics();
                    float pixelDensity = metrics.density;

                    int actionBarHeight = (int)(pixelDensity*ACTION_BAR_HEIGHT);
                    TypedValue tv = new TypedValue();
                    if(getTheme().resolveAttribute(android.R.attr.actionBarSize,tv,true)){
                        actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,metrics);
                    }

                    int statusBarHeight = (int) (pixelDensity*STATUS_BAR_HEIGHT);
                    int resourcedId = res.getIdentifier("status_bar_height","dimen","android");
                    if(resourcedId != 0) {
                        statusBarHeight = res.getDimensionPixelSize(resourcedId);
                    }

                    windowWidth = size.x;
                    windowHeight = size.y - statusBarHeight - actionBarHeight;
                    params.leftMargin = new Random().nextInt(windowWidth);
                    params.topMargin = new Random().nextInt(windowHeight);

                    txt_fling.setLayoutParams(params);
                }
                return true;
            }
        });

    }
    public void buildGuiByCode(){

        rl = new RelativeLayout(this);

        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

        txt_fling = new TextView(this);
        txt_fling.setTextSize(32);
        txt_fling.setGravity(Gravity.CENTER);
        txt_fling.setBackgroundColor(Color.CYAN);
        txt_fling.setText("Fling Me");

        int left = params.leftMargin;
        int top = params.topMargin;
        Log.i("tttt", " "+ Integer.toString(left));

        rl.addView(txt_fling, params);

        setContentView(rl);

        txt_fling.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                ges_detec.onTouchEvent(motionEvent);

                return true;
            }
        });
    }


}
