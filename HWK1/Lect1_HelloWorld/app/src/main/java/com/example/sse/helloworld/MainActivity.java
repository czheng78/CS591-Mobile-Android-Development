package com.example.sse.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnSayHello;
    private EditText edtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btnSayHello = new Button(null);  //don't do it this way.
        btnSayHello = (Button) findViewById(R.id.btnSayHello);
        edtMessage = (EditText) findViewById(R.id.edtMessage);

        btnSayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtMessage.setText("homework 1 hello world app");
            }
        });





    }
}
