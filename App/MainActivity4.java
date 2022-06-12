package com.example.smart_stick;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {
    Button config_b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        config_b1=findViewById(R.id.config_b1);
        config_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity4.this, " Confirmed ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void radioHandle(View view) {
        boolean selected=((RadioButton)view).isChecked();
        switch (view.getId())
        {
            case R.id.config_r1:
                if(selected)
//                    Toast.makeText(this," Obstacle Detection Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.config_r2:
                if(selected)
//                    Toast.makeText(this,"Staircase Detection selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.config_r3:
                if(selected)
//                    Toast.makeText(this,"Pothole Detection selected",Toast.LENGTH_SHORT).show();
                    break;
            case R.id.config_r4:
                if(selected)
//                    Toast.makeText(this,"Water Detection selected",Toast.LENGTH_SHORT).show();
                    break;
            case R.id.config_r5:
                if(selected)
//                    Toast.makeText(this,"Fire Detection selected",Toast.LENGTH_SHORT).show();
                    break;
        }

    }
}
