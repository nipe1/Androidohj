package com.example.lab3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.startButton).setOnClickListener(this);
    }

    private String getTextFieldText() {
        EditText editor = findViewById(R.id.time);
        String text = editor.getText().toString();
        editor.setText(null);
        return text;
    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(this, TimerCountdownActivity.class);
        String message = getTextFieldText();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
