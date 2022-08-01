package com.example.smart_blind_stick;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Button set_b1,set_b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        set_b1=findViewById(R.id.set_b1);
        set_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(i);
            }
        });


        set_b2=findViewById(R.id.set_b2);
        set_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this,MainActivity4.class);
                startActivity(i);
            }
        });
    }

}
