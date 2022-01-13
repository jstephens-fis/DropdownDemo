package com.example.dropdowndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextInputLayout textInputLanguages;
    AutoCompleteTextView autoCompleteLanguages;
    ArrayList<String> languages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLanguages = findViewById(R.id.textInputLayout);
        autoCompleteLanguages = findViewById(R.id.autoCompleteTextView);
        languages = new ArrayList<>();

        languages.add("English");
        languages.add("German");
        languages.add("Korean");

        ArrayAdapter adapterLanguages = new ArrayAdapter(this, android.R.layout.simple_spinner_item, languages);
        autoCompleteLanguages.setAdapter(adapterLanguages);

        ((AutoCompleteTextView)textInputLanguages.getEditText()).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String result = adapterLanguages.getItem(position).toString();
                System.out.println(result);
            }
        });
    }
}