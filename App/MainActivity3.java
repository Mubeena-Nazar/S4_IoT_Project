package com.example.smart_blind_stick;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

        OkHttpClient client = new OkHttpClient();

        /*******************************   RETRIVING VALUES  *****************************************/

        String url = "http://192.168.1.2/get_value_telegram_msg";                                   // --------- IP address --------
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
                    MainActivity3.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            String value = myResponse;
                            //Toast.makeText(MainActivity3.this, value, Toast.LENGTH_LONG).show();
                            String[] parts = value.split(" # ");
                            String part1 = parts[0].replaceAll("[\\n]", "");
                            String part2 = parts[1].replaceAll("[\\n]", "");
                            String part3 = parts[2].replaceAll("[\\n]", "");
                            emg_e1.setText(part1);
                            emg_e3.setText(part2);
                            emg_e2.setText(part3);



                        }
                    });
                }
            }
        });


        /*******************************  DETECTING OBSTACLES  *****************************************/

        emg_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = emg_e1.getText().toString();
                int num = Integer.parseInt(emg_e2.getText().toString());
                String msg = emg_e3.getText().toString();


                Toast.makeText(MainActivity3.this, "\nName : " + name + " \nTelegramId : " + num + " \nMessage : " + msg, Toast.LENGTH_SHORT).show();


                String url = "http://192.168.1.2/";                                                 // --------- IP address --------
                String url_song = url + "set_msg_config?";

                url_song +="Name_Id=";
                url_song += name;

                url_song +="&Num_Id=";
                url_song += num;

                url_song +="&Msg_Id=";
                url_song += msg;


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

                            MainActivity3.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //Toast.makeText(MainActivity3.this, "Done", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });

            }
        });
    }

}
