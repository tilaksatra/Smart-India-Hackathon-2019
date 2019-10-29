package com.example.dellayush.talkingfingers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

public class Emotions extends AppCompatActivity {

    Intent backIntent;
    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotions);
//        gridLayout = findViewById(R.id.gridlayout);
    }

    public void onHappy(View view){
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("happy",returnInputAgain);
    }

    public void afraid(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("afraid",returnInputAgain);    }

    public void crazy(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("crazy",returnInputAgain);    }

    public void depressed(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("depressed",returnInputAgain);    }

    public void disgusting(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("disgusted",returnInputAgain);    }


    public void love(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("love",returnInputAgain);    }

    public void  poor(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("poor",returnInputAgain);    }

    public void  proud(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("proud",returnInputAgain);    }

    public void  regretful(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("regretful",returnInputAgain);    }

    public void sad(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("sad",returnInputAgain);    }

    public void  shocked(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("shocked",returnInputAgain);
    }

    public void  sleepy(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("sleepy",returnInputAgain);
    }

    public void  smile(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("smile",returnInputAgain);
    }

    public void  suffer(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("suffer",returnInputAgain);
    }

    public void  tired(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("tired",returnInputAgain);
    }

    public void  trusted(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("trusted",returnInputAgain);
    }

//    public void  wondering(View view)
//    {
//        Intent intent = getIntent();
//        Bundle data = intent.getExtras();
//        String actName = data.getString("activityName");
//        String returnInputAgain = data.getString("inputSentence");
//        playVideo("wondering",returnInputAgain);
//    }

    public void  shouting(View view)
    {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("shouting",returnInputAgain);
    }

    public void  mad(View view) {
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        String actName = data.getString("activityName");
        String returnInputAgain = data.getString("inputSentence");
        playVideo("mad",returnInputAgain);
    }




    public void playVideo(String emojiValue, String inputValue){
            Intent toVideoPlay = new Intent(Emotions.this,VideoPlay.class);
            toVideoPlay.putExtra("emojiValue", emojiValue);
            toVideoPlay.putExtra("categoryValue", inputValue);
            startActivity(toVideoPlay);
    }

}
