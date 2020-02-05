package com.example.lab2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.map).setOnClickListener(this);
        findViewById(R.id.searchButton).setOnClickListener(this);
        findViewById(R.id.call).setOnClickListener(this);

    }

    private String getTextFieldText() {
        EditText editor = findViewById(R.id.call);
        String text = editor.getText().toString();
        editor.setText(null);
        return text;
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.call) {
            Uri number = Uri.parse("tel:+358206110200");
            Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
            startActivity(callIntent);
        }
        else if (v.getId() == R.id.map) {
            Uri location = Uri.parse("geo:3F58+PG Linnanmaa, Oulu");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
            startActivity(mapIntent);
        }
        else if (v.getId() == R.id.searchButton) {
            Uri webpage = Uri.parse(getTextFieldText());
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(webIntent);
        }
    }
}
