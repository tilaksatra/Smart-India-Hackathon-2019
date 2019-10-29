package com.example.dellayush.talkingfingers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DictionaryOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary_options);
    }

    public void digits(View view){
        Intent toDigit = new Intent(DictionaryOptions.this,Digits.class);
        startActivity(toDigit);
    }

    public void alphabets(View view){
        Intent toAlphabets = new Intent(DictionaryOptions.this,Alphabets.class);
        startActivity(toAlphabets);
    }

    public void colors(View view){
        Intent toColors = new Intent(DictionaryOptions.this,Colors.class);
        startActivity(toColors);
    }

}
