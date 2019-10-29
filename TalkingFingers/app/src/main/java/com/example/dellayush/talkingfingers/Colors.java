package com.example.dellayush.talkingfingers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Colors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        Log.d("Str","Orange");
    }

    public void red(View view){
        callVideo("red");
    }

    public void blue(View view){
        callVideo("blue");
    }

    public void green(View view) {
        callVideo("green");
    }

    public void yellow(View view){
        callVideo("yellow");
    }

    public void orange(View view){
        callVideo("orange");
    }

    public void callVideo(String colorValue){
        Intent toVideoPlay = new Intent(Colors.this,VideoPlay.class);
        toVideoPlay.putExtra("categoryValue",colorValue);
        startActivity(toVideoPlay);
    }

}
