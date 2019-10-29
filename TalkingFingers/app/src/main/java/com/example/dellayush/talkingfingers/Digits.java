package com.example.dellayush.talkingfingers;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Digits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digits);
    }

    public void onZero(View view){
        Toast.makeText(this,"Video Not Availabe! We'll get back soon",Toast.LENGTH_LONG).show();
        callVideo("zero");
    }


    public void onOne(View view){
        callVideo("one");
    }

    public void onTwo(View view){
        callVideo("two");
    }

    public void onThree(View view)
    {
        callVideo("three");

    }

    public void onFour(View view){
        callVideo("four");
    }

    public void onFive(View view){
        callVideo("five");

    }

    public void onSix(View view){
        callVideo("six");

    }

    public void onSeven(View view){
        callVideo("seven");

    }

    public void onEight(View view){
        callVideo("eight");
    }

    public void onNine(View view){
        callVideo("nine");
    }

    public void callVideo(String digitValue){
        Intent toVideoPlay = new Intent(Digits.this,VideoPlay.class);
        toVideoPlay.putExtra("categoryValue",digitValue);
        startActivity(toVideoPlay);
    }

}
