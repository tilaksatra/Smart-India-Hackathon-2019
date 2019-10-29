package com.example.dellayush.talkingfingers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Alphabets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);
    }

    public void onA(View view){
        callVideo("a");
    }

    public void onB(View view){
        callVideo("b");
    }
    public void onC(View view){
        callVideo("c");
    }

    public void onD(View view){
        callVideo("d");
    }

    public void onE(View view){
        callVideo("e");
    }

    public void onF(View view){
        callVideo("f");
    }

    public void onG(View view){
        callVideo("g");
    }

    public void onH(View view){
        callVideo("h");
    }
    public void onI(View view){
        callVideo("i");
    }
    public void onJ(View view){
        callVideo("j");
    }

    public void onK(View view){
        callVideo("k");
    }

    public void onL(View view){
        callVideo("l");
    }

    public void onM(View view){
        callVideo("m");
    }

    public void onN(View view){
        callVideo("n");
    }

    public void onO(View view){
        callVideo("o");
    }

    public void onP(View view){
        callVideo("p");
    }

    public void onQ(View view){
        callVideo("q");
    }

    public void onR(View view){
        callVideo("r");
    }

    public void onS(View view){
        callVideo("s");
    }

    public void onT(View view){
        callVideo("t");
    }

    public void onU(View view){
        callVideo("u");
    }

    public void onV(View view){
        callVideo("v");
    }

    public void onW(View view){
        callVideo("w");
    }

    public void onX(View view){
        callVideo("x");
    }

    public void onY(View view){
        callVideo("y");
    }

    public void onZ(View view){
        callVideo("z");
    }


    public void callVideo(String alphabetValue){
        Intent toVideoPlay = new Intent(Alphabets.this,VideoPlay.class);
        toVideoPlay.putExtra("categoryValue",alphabetValue);
        startActivity(toVideoPlay);
    }


}
