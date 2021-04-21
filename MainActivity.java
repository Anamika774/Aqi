package com.example.airquality;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText name,email,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.signIn);
        name=findViewById(R.id.ename);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashBoard();
            }
        });

    }

    private void openDashBoard() {
        String username=name.getText().toString();
        Intent intent=new Intent(this,Act2.class);
        intent.putExtra("keyname",username);
        startActivity(intent);

    }
}
