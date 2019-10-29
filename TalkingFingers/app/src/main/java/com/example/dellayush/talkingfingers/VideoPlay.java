package com.example.dellayush.talkingfingers;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.luolc.emojirain.EmojiRainLayout;

import java.util.ArrayList;
import java.util.List;

public class VideoPlay extends AppCompatActivity {

    VideoView videoView;
    TextView textView;
    String message = "";
    EmojiRainLayout emojiRainLayout;
    Context mContext;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        videoView = findViewById(R.id.playVideoView);
        textView = findViewById(R.id.myTextView);
        mContext = getBaseContext();
        emojiRainLayout = findViewById(R.id.layout);
        playVideo();
    }

    public void playVideo(){
        String emoji = "";
        Intent videoData = getIntent();
        String message = videoData.getStringExtra("categoryValue");
        String originalMessage = message;
        if(videoData.hasExtra("emojiValue")){
            emoji = videoData.getStringExtra("emojiValue");
        }
        message = getHifenString(message);

        if(message.equals("")){
            Toast.makeText(this,"No Sign Language To Show For Empty Text",Toast.LENGTH_LONG).show();
        }else{
            List<String> videoPath = new ArrayList<>();
            List<String> finalWords = new ArrayList<>();
            if(!(message.equals(""))) {
                if(checkSentenceInRaw(message)){
                    String path = "android.resource://" + getPackageName() + "/" + "raw/" + message;
                    startVideo(path,emoji,originalMessage);
                }else{
                    String path = "";
                    String words[] = originalMessage.split(" ");
                    for(String word : words){
                        if(checkSentenceInRaw(word)){
                            path = "android.resource://" + getPackageName() + "/" + "raw/" + word;
                            videoPath.add(path);
                            finalWords.add(word);
                        }else{
                            for(int start=0;start<word.length();start++) {
                                path = "android.resource://" + getPackageName() + "/" + "raw/" + word.charAt(start) + "";
                                videoPath.add(path);
                            }
                            finalWords.add(word);
                        }
                    }
                    startVideo(videoPath.get(0),emoji,originalMessage,videoPath);
                }
            }
        }



    }


    private void startVideo(String path, String emoji, String ogMessage){
        final MediaController mediacontroller = new MediaController(this);
        mediacontroller.setAnchorView(videoView);
        videoView.setMediaController(mediacontroller);
        videoView.requestFocus();
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();
        insertEmoji(emoji);
        textView.setText(ogMessage.toUpperCase());
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        videoView.setMediaController(mediacontroller);
                        mediacontroller.setAnchorView(videoView);
                    }
                });
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
//                Toast.makeText(getApplicationContext(), "Video over", Toast.LENGTH_SHORT).show();
                playVideo();
            }
        });
    }

    private void startVideo(String path, String emoji, String ogMessage, final List<String> myList){
        final MediaController mediacontroller = new MediaController(this);
        mediacontroller.setAnchorView(videoView);
        videoView.setMediaController(mediacontroller);
        videoView.requestFocus();
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();
        insertEmoji(emoji);
        textView.setText(ogMessage.toUpperCase());
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        videoView.setMediaController(mediacontroller);
                        mediacontroller.setAnchorView(videoView);
                    }
                });
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                counter++;
                if(counter<myList.size()){
                    videoView.setMediaController(mediacontroller);
                    videoView.setVideoURI(Uri.parse(myList.get(counter)));
                    videoView.requestFocus();
                    videoView.start();
                }

            }
        });
    }

    public boolean checkSentenceInRaw(String sentence){
        Boolean result = false;
        int checkExistence = mContext.getResources().getIdentifier(sentence, "raw", mContext.getPackageName());
        if (checkExistence != 0) {  // the resouce exists...
            result = true;
        }
        else {  // checkExistence == 0  // the resouce does NOT exist!!
            result = false;
        }
        return result;
    }

    public void insertEmoji(String emoji){
        switch (emoji){
            case "happy":
                emojiRainLayout.addEmoji(R.drawable.happysm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;


            case "shocked":
                emojiRainLayout.addEmoji(R.drawable.shockedsm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "afraid":
                emojiRainLayout.addEmoji(R.drawable.afraidsm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "crazy":
                emojiRainLayout.addEmoji(R.drawable.crazysm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "depressed":
                emojiRainLayout.addEmoji(R.drawable.depressedsm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "disgusted":
                emojiRainLayout.addEmoji(R.drawable.disjustedsm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "mad":
                emojiRainLayout.addEmoji(R.drawable.madsm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "regretful":
                emojiRainLayout.addEmoji(R.drawable.regretfulsm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "love":
                emojiRainLayout.addEmoji(R.drawable.lovesm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "poor":
                emojiRainLayout.addEmoji(R.drawable.poorsm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "proud":
                emojiRainLayout.addEmoji(R.drawable.proudsm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "sad":
                emojiRainLayout.addEmoji(R.drawable.sadsm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "shouting":
                emojiRainLayout.addEmoji(R.drawable.shoutingsm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "sleepy":
                emojiRainLayout.addEmoji(R.drawable.sleepysm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "smile":
                emojiRainLayout.addEmoji(R.drawable.smilesm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "suffer":
                emojiRainLayout.addEmoji(R.drawable.suffersm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "tired":
                emojiRainLayout.addEmoji(R.drawable.tiredsm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            case "trusted":
                emojiRainLayout.addEmoji(R.drawable.trustedsm);
                emojiRainLayout.stopDropping();
                emojiRainLayout.setPer(10);
                emojiRainLayout.setDuration(4000);
                emojiRainLayout.setDropDuration(4000);
                emojiRainLayout.setDropFrequency(1050);
                emojiRainLayout.startDropping();
                break;

            default:
                break;
        }
    }

    public String getHifenString(String input){
        String words[] = input.split(" ");
        if(words.length>1){
            String hifenString = "";
            hifenString = words[0] +"_";
            for(int start = 1; start<words.length;start++){
                if(start==words.length-1){
                    hifenString += words[start];
                }else{
                    hifenString += words[start]+"_";
                }
            }
            return hifenString;
        }
        return input;
    }

}
