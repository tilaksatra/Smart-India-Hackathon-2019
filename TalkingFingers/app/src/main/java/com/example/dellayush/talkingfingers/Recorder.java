package com.example.dellayush.talkingfingers;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.List;

public class Recorder extends AppCompatActivity {

    private static final int SPEECH_REQUEST_CODE = 0;
    ImageButton btn;
    EditText text;
    String inputText = "";
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorder);
        btn = findViewById(R.id.simpleImageView);
        imageView = findViewById(R.id.simpleImageView);
        text = findViewById(R.id.spokenText);
    }

    public void displaySpeechRecognizer(View view){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        // Start the activity, the intent will be populated with the speech text
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String spoken = results.get(0);
            text.setText(spoken);
            inputText = text.getText().toString();
        }
    }

    public void emotionClick(View view){
        Intent toEmotions = new Intent(Recorder.this,Emotions.class);
        toEmotions.putExtra("inputSentence",inputText.toLowerCase());
        startActivity(toEmotions);
    }
}
