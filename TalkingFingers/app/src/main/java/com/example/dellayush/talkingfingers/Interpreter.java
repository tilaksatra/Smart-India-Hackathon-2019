package com.example.dellayush.talkingfingers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Interpreter extends AppCompatActivity {

    EditText input;
    Spinner spinner;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpreter);
        input = findViewById(R.id.sentence);
    }

    public void onEmojiClick(View view){
        Intent toEmotions = new Intent(Interpreter.this,Emotions.class);
        toEmotions.putExtra("inputSentence",input.getText().toString().toLowerCase());
        startActivity(toEmotions);
    }

}
