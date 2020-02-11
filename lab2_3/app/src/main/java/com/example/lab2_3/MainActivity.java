package com.example.lab2_3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView Greet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Greet = findViewById(R.id.textGreet);
        findViewById(R.id.buttonEnglish).setOnClickListener(this);
        findViewById(R.id.buttonSuomeksi).setOnClickListener(this);
        findViewById(R.id.buttonSverige).setOnClickListener(this);
        findViewById(R.id.buttonSurprise).setOnClickListener(this);
    }

    private String getFieldText() {
        EditText Edit = findViewById(R.id.name);
        String text = Edit.getText().toString();
        return text;
    }

    @Override
    public void onClick(View v){
        String text = getFieldText();
        if(v.getId()==R.id.buttonEnglish){
            Greet.setText("Hello " + text);
        }
        else if(v.getId()==R.id.buttonSverige){
            Greet.setText("Hejjsan " + text);
        }
        else if(v.getId()==R.id.buttonSuomeksi){
            Greet.setText("Hei " + text);
        }
        else if(v.getId()==R.id.buttonSurprise){
            Greet.setText("Hola " + text);
        }
    }
}
