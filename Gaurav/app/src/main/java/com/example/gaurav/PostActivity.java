package com.example.gaurav;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.net.URI;

public class PostActivity extends AppCompatActivity {
    ImageView imageView;
    Button setprofile;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        imageView=findViewById(R.id.imageView);
        setprofile=findViewById(R.id.setprofile);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                i want user to gallery to pick a photo
              Intent opengalleryintent= new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
              startActivityForResult(opengalleryintent,2000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==2000)
        {
            if (requestCode==Activity.RESULT_OK)
            {
                Uri imageuri=data.getData();
                imageView.setImageURI(imageuri);
            }
        }
    }
}