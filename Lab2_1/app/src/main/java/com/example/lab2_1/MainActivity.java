package com.example.lab2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> COUNTRIES = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.buttonAdd).setOnClickListener(this);
        findViewById(R.id.buttonRemove).setOnClickListener(this);

        String[] startCountries = new String[]{"Afghanistan","Albania",
                "Algeria","American Samoa","Andorra", "Angola","Anguilla",
                "Antarctica","Antigua and Barbuda","Argentina",
                "Armenia","Aruba","Australia","Austria","Azerbaijan"};
        COUNTRIES.addAll(Arrays.asList(startCountries));
        printAll();
    }
    private void printAll() {
        ListView myListView = (ListView) findViewById(R.id.listCountry);
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, COUNTRIES);
        myListView.setAdapter(aa);
    }

    private String getTextFieldText() {
        EditText editor = findViewById(R.id.editCountry);
        String text = editor.getText().toString();
        editor.setText(null);
        return text;
    }

    private void removeCountry(String Country)
    {
        for (int i = 0; i < COUNTRIES.size(); i++) {
            String arrayCountry = COUNTRIES.get(i);
            if (arrayCountry.equalsIgnoreCase(Country))
            {
                COUNTRIES.remove(i);
                break;
            }
        }
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.buttonAdd) {
            String country = getTextFieldText();
            if(country != null && country.length() > 0){
                COUNTRIES.add(country);
            }
        }
        else if(v.getId() == R.id.buttonRemove) {
            String country = getTextFieldText();
            removeCountry(country);
        }
        printAll();
    }
}
