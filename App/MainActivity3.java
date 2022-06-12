package com.example.smart_stick;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    Button emg_b1;
    EditText emg_e1,emg_e2,emg_e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        emg_e1=findViewById(R.id.emg_e1);
        emg_e2=findViewById(R.id.emg_e2);
        emg_e3=findViewById(R.id.emg_e3);



        emg_b1=findViewById(R.id.emg_b1);
        emg_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity3.this, " Confirmed ", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
