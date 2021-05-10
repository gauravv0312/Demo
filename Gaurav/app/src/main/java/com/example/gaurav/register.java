package com.example.gaurav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {
    public static final  String TAG="TAG";
   EditText name,email,number,password,cpassword;
   Button button2;
   FirebaseAuth fAuth;
   FirebaseFirestore fStore;
   String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        number=findViewById(R.id.number);
        password=findViewById(R.id.password);
        cpassword=findViewById(R.id.cpassword);
        button2=findViewById(R.id.button2);
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email= email.getText().toString().trim();
                String Password=password.getText().toString().trim();
                String Cpassword=cpassword.getText().toString().trim();
                String Name=name.getText().toString();
                String Number=number.getText().toString();
                if(TextUtils.isEmpty(Email))
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
                    password.setError("Password Must be equal to 6 character or greater than 6");
                    return;
                }
                if(TextUtils.isEmpty(Name))
                {
                    name.setError("Please Enter Your Name");
                    return;
                }




                if (Password.equals(Cpassword)) {

                    fAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if (task.isSuccessful()) {
                                Toast.makeText(register.this, "User Created", Toast.LENGTH_SHORT).show();
                                userID = fAuth.getCurrentUser().getUid();
                                DocumentReference documentReference = fStore.collection("user").document(userID);
                                Map<String, Object> user = new HashMap<>();
                                user.put("Fname", Name);
                                user.put("Email", Email);
                                user.put("MobileNo", Number);
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "OnSuccess : user profile is created for " + userID);
                                    }
                                });
                                startActivity(new Intent(getApplicationContext(), MainContent.class));
                            } else {
                                Toast.makeText(register.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }


                        }
                    });

                }
                else{
                    cpassword.setError("Please enter same password as you enter above");
                }
            }
        });
    }
}