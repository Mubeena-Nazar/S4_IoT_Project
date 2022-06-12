package com.example.smart_stick;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    Button find_b1,find_b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        find_b1=findViewById(R.id.find_b1);
        find_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity5.this, " ON ", Toast.LENGTH_SHORT).show();
            }
        });

        find_b2=findViewById(R.id.find_b2);
        find_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity5.this, " OFF ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
