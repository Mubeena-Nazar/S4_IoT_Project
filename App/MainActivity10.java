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

public class MainActivity10 extends AppCompatActivity {
    Button config_b1;
    EditText config_e;
    String song = "song5";
    int dis = 10;
    String det="Fire Detection";

    public void radioHandle(View view) {
        boolean selected_song = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.config_s1:
                if (selected_song) {
                    song = "song1";
                }
                break;
            case R.id.config_s2:
                if (selected_song) {
                    song = "song2";
                }
                break;
            case R.id.config_s3:
                if (selected_song) {
                    song = "song3";
                }
                break;
            case R.id.config_s4:
                if (selected_song) {
                    song = "song4";
                }
                break;
            case R.id.config_s5:
                if (selected_song) {
                    song = "song5";
                }
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        config_b1 = findViewById(R.id.config_b1);
        config_e = findViewById(R.id.config_e);
        OkHttpClient client = new OkHttpClient();
        /*******************************   RETRIVING VALUES  *****************************************/

        String url = "http://192.168.1.2/get_value_fire";                                           // --------- IP address --------
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {

                    final String myResponse = response.body().string();
                    MainActivity10.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            String value = myResponse;
                            //Toast.makeText(MainActivity10.this, value, Toast.LENGTH_LONG).show();

                            String[] parts = value.split(" ");
                            String part1 = parts[0].replaceAll("[\\n\t ]", "");;
                            String part2 = parts[1].replaceAll("[\\n\t ]", "");;
                            config_e.setText(part1);

                            String val = part2 ;
                            switch(val){
                                case "song1":
                                    RadioButton b1 = (RadioButton) findViewById(R.id.config_s1);
                                    b1.setChecked(true);
                                    break;
                                case "song2":
                                    RadioButton b2 = (RadioButton) findViewById(R.id.config_s2);
                                    b2.setChecked(true);
                                    break;
                                case "song3":
                                    RadioButton b3 = (RadioButton) findViewById(R.id.config_s3);
                                    b3.setChecked(true);
                                    break;
                                case "song4":
                                    RadioButton b4 = (RadioButton) findViewById(R.id.config_s4);
                                    b4.setChecked(true);
                                    break;
                                case "song5":
                                    RadioButton b5 = (RadioButton) findViewById(R.id.config_s5);
                                    b5.setChecked(true);
                                    break;
                                default:
                                    Toast.makeText(MainActivity10.this, "Invalid", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


        /*******************************  DETECTING OBSTACLES  *****************************************/
        config_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis = Integer.parseInt(config_e.getText().toString());


                // Detection = det
                // Sound     = song
                // Distance  = dis


                Toast.makeText(MainActivity10.this, "\nDetection =" + det + " \nSong =" + song + " \nDistance =" + dis, Toast.LENGTH_SHORT).show();

                String url = "http://192.168.1.2/";                                                 // --------- IP address --------
                String url_song = url + "set_config_fire?";

                url_song +="detectionId=";
                url_song += det;

                url_song +="&songId=";
                url_song += song;

                url_song +="&distanceId=";
                url_song += dis;


                Request request = new Request.Builder()
                        .url(url_song)
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful()) {
                            final String myResponse = response.body().string();

                            MainActivity10.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //Toast.makeText(MainActivity10.this, "Successfully Connected", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });

            }
        });
    }
}
