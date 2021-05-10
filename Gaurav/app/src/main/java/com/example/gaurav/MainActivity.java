package com.example.gaurav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     TextView textView;
     Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
    }
//    public void register (View view){
//        Toast.makeText(this, "Welcome to Registration Page", Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(getApplicationContext(),register.class));
//    }
    public void register (View view)
    {
        Toast.makeText(this, "welcome to profile page", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),PostActivity.class));
    }

}