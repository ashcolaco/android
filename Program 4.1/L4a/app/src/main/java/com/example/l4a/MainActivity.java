package com.example.l4a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{
    private static final int CAMERA_REQUEST=1888;
    ImageView imageView;
    //Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        Button button = (Button)this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File picDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String picName = getPictureName();
                File imagefile = new File(picDirectory, picName);
                Uri picUri = Uri.fromFile(imagefile);
                cam.putExtra(MediaStore.EXTRA_OUTPUT,picUri);
                startActivityForResult(cam, CAMERA_REQUEST);
            }
        });
    }

    private String getPictureName()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date());
        return "Plane place Image"+timestamp+".jpg";
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_OK)
        {
            if(requestCode == CAMERA_REQUEST)
            {

            }
        }
    }
}