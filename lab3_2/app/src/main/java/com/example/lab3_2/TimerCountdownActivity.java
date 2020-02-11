package com.example.lab3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.os.CountDownTimer;

public class TimerCountdownActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_countdown);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int time = Integer.parseInt(message) * 1000;
        Countdown(time);
    }

    private void Countdown(int time){
        final TextView textView = findViewById(R.id.timer);
        new CountDownTimer(time, 1000){
            public void onTick(long millisUntilFinished){
                textView.setText(""+millisUntilFinished / 1000);
            }

            public void onFinish(){
                textView.setText("done");
            }
        }.start();
    }
}
