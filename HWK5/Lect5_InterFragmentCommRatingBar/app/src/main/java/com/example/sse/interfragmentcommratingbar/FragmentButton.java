package com.example.sse.interfragmentcommratingbar;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.lang.reflect.Field;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentButton extends Fragment {

    private Button btnLeft;
    private Button btnRight;
    private int currDrawableIndex;
    ArrayList<Drawable> drawables;  //keeping track of our drawables

    public FragmentButton() {
        // Required empty public constructor
    }



    public interface PictureChangeListener {
        void changePicture(int currDrawableIndex);
        void saveRate(int currDrawableIndex);
    }

    PictureChangeListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (PictureChangeListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_button, container, false);

        btnRight = (Button) v.findViewById(R.id.btnRight);
        btnLeft = (Button) v.findViewById(R.id.btnLeft);

        currDrawableIndex = 0;
        getDrawables();


        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                rate.put(currDrawableIndex, ratingBar.getRating());
                listener.saveRate(currDrawableIndex);
                if (currDrawableIndex == 0)
                    currDrawableIndex = drawables.size() - 1;
                else
                    currDrawableIndex--;
                listener.changePicture(currDrawableIndex);
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.saveRate(currDrawableIndex);
//                rate.put(currDrawableIndex, ratingBar.getRating());
                if (currDrawableIndex == drawables.size() - 1)
                    currDrawableIndex = 0;
                else
                    currDrawableIndex++;
                listener.changePicture(currDrawableIndex);
            }
        });


        return v;
    }
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
    }

}
