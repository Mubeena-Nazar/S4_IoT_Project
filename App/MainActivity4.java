package com.example.smart_blind_stick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity4 extends AppCompatActivity {
    String det = "Obstacle Detection";

    public void radioHandle(View view) {
        boolean selected = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.config_r1:
                if (selected) {
                    det = "Obstacle Detection";
                }
                break;
            case R.id.config_r2:
                if (selected) {
                    det = "Staircase Detection";
                }
                break;
            case R.id.config_r3:
                if (selected) {
                    det = "Pothole Detection";
                }
                break;
            case R.id.config_r4:
                if (selected) {
                    det = "Water Detection";
                }
                break;
            case R.id.config_r5:
                if (selected) {
                    det = "Fire Detection";
                }
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        Button b1=(Button)findViewById(R.id.config_b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( det== "Obstacle Detection"){
                    Intent i_obstacle=new Intent(MainActivity4.this,MainActivity6.class);
                    startActivity(i_obstacle);
                }
                if( det== "Staircase Detection"){
                    Intent i_staircase=new Intent(MainActivity4.this,MainActivity7.class);
                    startActivity(i_staircase);
                }
                if( det== "Pothole Detection"){
                    Intent i_pothole=new Intent(MainActivity4.this,MainActivity8.class);
                    startActivity(i_pothole);
                }
                if( det== "Water Detection"){
                    Intent i_water=new Intent(MainActivity4.this,MainActivity9.class);
                    startActivity(i_water);
                }
                if( det== "Fire Detection"){
                    Intent i_fire=new Intent(MainActivity4.this,MainActivity10.class);
                    startActivity(i_fire);
                }
            }
        });



    }
}
