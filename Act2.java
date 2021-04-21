package com.example.airquality;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Act2 extends AppCompatActivity {
    private TextView name;
    Button loc;
    public static TextView data;
    public static TextView cname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        name=findViewById(R.id.uname);
        loc= findViewById(R.id.location_btn);
        data=findViewById(R.id.temp);
        cname=findViewById(R.id.city);


        String username=getIntent().getStringExtra("keyname");
        name.setText("Hi"+" " +username);

        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData process=new fetchData();
                process.execute();

            }
        });


    }
}
