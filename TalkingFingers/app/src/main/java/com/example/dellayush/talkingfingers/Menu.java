package com.example.dellayush.talkingfingers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void interpreter(View view){
        Toast.makeText(this,"Interpreter clicked",Toast.LENGTH_SHORT).show();
        Intent toInterpreter = new Intent(Menu.this,Interpreter.class);
        startActivity(toInterpreter);
    }

    public void recorder(View view){
        Toast.makeText(this,"Recorder clicked",Toast.LENGTH_SHORT).show();
        Intent toRecorder = new Intent(Menu.this, Recorder.class);
        startActivity(toRecorder);
    }

    public void camera(View view){
        Toast.makeText(this,"Camera clicked",Toast.LENGTH_SHORT).show();
        Intent toCamera = new Intent(Menu.this,Camera.class);
        startActivity(toCamera);
    }

    public void dictionary(View view){
        Toast.makeText(this,"Dictionary clicked",Toast.LENGTH_SHORT).show();
        Intent toDictionaryOptions = new Intent(Menu.this,DictionaryOptions.class);
        startActivity(toDictionaryOptions);
    }


}
