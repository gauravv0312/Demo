package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {
    ImageView imageView;
    Button register;
    EditText name,email,phone,password,cpassword;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    private String Email;
    private  String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        imageView=findViewById(R.id.imageView);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.password);
        cpassword=findViewById(R.id.cpassword);
        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email =email.getText().toString().trim();
                String Password= password.getText().toString().trim();
                String Name= name.getText().toString();
                String Cpassword = cpassword.getText().toString().trim();
                if (TextUtils.isEmpty(Email))
                {
                    email.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(Password))
                {
                    password.setError("Password is required");
                    return;
                }
                if (Password.length()<6)
                {
                    password.setError("Password must be of 6 character or greater than 6");
                    return;
                }

                if (TextUtils.isEmpty(Cpassword))
                {
                    cpassword.setError("Please Confirm Your Password");
                    return;
                }

                if (TextUtils.isEmpty(Name))
                {
                    name.setError("Please your name");
                    return;
                }

//                Toast.makeText(RegisterActivity.this, "Welcome to registeration page", Toast.LENGTH_SHORT).show();

                  Signup();
                
            }
        });
    }

     private void Signup() {
        fAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(RegisterActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),ContactActivity.class));
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
