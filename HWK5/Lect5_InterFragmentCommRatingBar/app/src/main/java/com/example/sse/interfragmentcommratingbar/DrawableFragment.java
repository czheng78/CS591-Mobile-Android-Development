package com.example.sse.interfragmentcommratingbar;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrawableFragment extends Fragment {

    ArrayList<Drawable> drawables;  //keeping track of our drawables
    private int currDrawableIndex;  //keeping track of which drawable is currently displayed.

    //Boiler Plate Stuff.
    private ImageView imgRateMe;
    //    private Button btnLeft;
//    private Button btnRight;
    private RatingBar ratingBar;
//    private int pre_index;

    HashMap<Integer, Float> rate = new HashMap<>();

//    public DrawableFragment() {
//        // Required empty public constructor
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_drawable, container, false);  //comment this out, it would return the default view, without our setup/amendments.
        View v = inflater.inflate(R.layout.fragment_drawable, container, false);   //MUST HAPPEN FIRST, otherwise components don't exist.

        imgRateMe = (ImageView) v.findViewById(R.id.imgRateMe);
//        btnRight = (Button) v.findViewById(R.id.btnRight);
//        btnLeft = (Button) v.findViewById(R.id.btnLeft);
        ratingBar = (RatingBar) v.findViewById(R.id.ratingBar);

        Log.i("checking", "stop00");
//
//        pre_index = 0;
//
//
        currDrawableIndex = 0;  //ArrayList Index of Current Drawable.
        getDrawables();         //Retrieves the drawables we want, ie, prefixed with "animal_"
        imgRateMe.setImageDrawable(null);  //Clearing out the default image from design time.
        changePicture(currDrawableIndex);        //Sets the ImageView to the first drawable in the list.


//setting up navigation call backs.  (Left and Right Buttons)
//        btnLeft.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rate.put(currDrawableIndex, ratingBar.getRating());
//                if (currDrawableIndex == 0)
//                    currDrawableIndex = drawables.size() - 1;
//                else
//                    currDrawableIndex--;
//                changePicture();
//            }
//        });
//
//        btnRight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rate.put(currDrawableIndex, ratingBar.getRating());
//                if (currDrawableIndex == drawables.size() - 1)
//                    currDrawableIndex = 0;
//                else
//                    currDrawableIndex++;
//                changePicture();
//            }
//        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
//                rate.put(currDrawableIndex, ratingBar.getRating());
            }
        });

        return v;   //returns the view, with our must happen last, Why? A: ____________
    }
    public void saveRate(int currDrawableIndex) {
        rate.put(currDrawableIndex, ratingBar.getRating());
    }


    //Routine to change the picture in the image view dynamically.
    public void changePicture(int currDrawableIndex) {
        Log.i("checking", "picture_change curr index: " + Integer.toString(currDrawableIndex));
        Log.i("checking", "picture_change get rate: " + Float.toString(ratingBar.getRating()));
        imgRateMe.setImageDrawable(drawables.get(currDrawableIndex));  //note, this is the preferred way of changing images, don't worry about parent viewgroup size changes.
        try {
            Log.i("checking", "try");
            ratingBar.setRating(rate.get(currDrawableIndex));
        } catch (Exception e) {
            Log.i("checking", "catch");
            ratingBar.setRating(0);
            rate.put(currDrawableIndex, ratingBar.getRating());
        }
    }

    //Quick and Dirty way to get drawable resources, we prefix with "animal_" to filter out just the ones we want to display.
//REF: http://stackoverflow.com/questions/31921927/how-to-get-all-drawable-resources
    public void getDrawables() {
        Field[] drawablesFields = com.example.sse.interfragmentcommratingbar.R.drawable.class.getFields();  //getting array of ALL drawables.
        drawables = new ArrayList<>();  //we prefer an ArrayList, to store the drawables we are interested in.  Why ArrayList and not an Array here? A: _________

        String fieldName;
        for (Field field : drawablesFields) {   //1. Looping over the Array of All Drawables...
            try {
                fieldName = field.getName();    //2. Identifying the Drawables Name, eg, "animal_bewildered_monkey"
                Log.i("LOG_TAG", "com.your.project.R.drawable." + fieldName);
                if (fieldName.startsWith("animals_"))  //3. Adding drawable resources that have our prefix, specifically "animal_".
                    drawables.add(getResources().getDrawable(field.getInt(null)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//    }
    }
}