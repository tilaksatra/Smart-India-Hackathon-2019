package com.example.dellayush.talkingfingers;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;

public class Camera extends AppCompatActivity {

    Button image, video, save;
    ImageView imageView;
    private final int CAPTURE_IMAGE = 1;
    private final int CAPTURE_VIDEO = 1;
    EditText fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        image = (Button) findViewById(R.id.image);
        video = (Button) findViewById(R.id.video);
//        save = (Button) findViewById(R.id.save);
        imageView = (ImageView) findViewById(R.id.imageView);
//        fileName = (EditText) findViewById(R.id.fileName);
        if(!hasCamera()){
            image.setEnabled(false);
            video.setEnabled(false);
//            save.setEnabled(false);
        }
//        if(fileName.getText().toString().equals("")){
//            save.setEnabled(false);
//        }
    }

    public void captureImage(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }

    public void captureVideo(View view){
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intent,2);
    }

    public boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

//    public void onSave(View view){
////        File videoFileName = getFilepath();
////        Uri videoUri = Uri.fromFile(videoFileName);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CAPTURE_IMAGE && resultCode==RESULT_OK) {
            Bundle bundle = data.getExtras();
            Bitmap photo = (Bitmap) bundle.get("data");
            imageView.setImageBitmap(photo);
        }
        if (requestCode==CAPTURE_VIDEO && resultCode==RESULT_OK) {
//            Bundle bundle = data.getExtras();
//            Bitmap video = (Bitmap) bundle.get("data");
        }
    }

    public File getFilepath() {
        File folder = new File("sdcard/TalkingFingers");
        if(!folder.exists()) {
            folder.mkdir();
        }
        String fName = fileName.getText().toString();
        File fileName = new File(folder,fName);
        return fileName;
    }


}
