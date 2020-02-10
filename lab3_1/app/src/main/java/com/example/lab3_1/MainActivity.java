package com.example.lab3_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    EditText editNotes;
    SharedPreferences sharedPreferences;
    public static final String editKey = "editKey";
    public static final String mypreference = "mypref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNotes = (EditText) findViewById(R.id.editNote);

        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(editKey)){
            editNotes.setText(sharedPreferences.getString(editKey, ""));
        }
    }

    protected void onPause(){
        super.onPause();
        String n = editNotes.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(editKey, n);
        editor.commit();
    }

}
