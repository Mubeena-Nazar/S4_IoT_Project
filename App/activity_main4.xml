package com.example.smart_stick;

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
                    Toast.makeText(this, " Obstacle Detection Selected", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.config_r2:
                if (selected) {
                    det = "Staircase Detection";
                    Toast.makeText(this, "Staircase Detection selected", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.config_r3:
                if (selected) {
                    det = "Pothole Detection";
                    Toast.makeText(this, "Pothole Detection selected", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.config_r4:
                if (selected) {
                    det = "Water Detection";
                    Toast.makeText(this, "Water Detection selected", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.config_r5:
                if (selected) {
                    det = "Fire Detection";
                    Toast.makeText(this, "Fire Detection selected", Toast.LENGTH_SHORT).show();
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
                Intent i=new Intent(MainActivity4.this,MainActivity6.class);
                i.putExtra("Message",det);
                startActivity(i);
            }
        });

    }
}
