package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.ui.HelperClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    EditText fullName,userName,Email,passWord;
    Button signUp,signupLogin;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullName=findViewById(R.id.fullName);
        userName=findViewById(R.id.userName);
        Email=findViewById(R.id.emailField);
        passWord=findViewById(R.id.passwordField);
        signUp=findViewById(R.id.signUp);
        signupLogin=findViewById(R.id.signupLogin);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database=FirebaseDatabase.getInstance();
                reference=database.getReference("users");

                String pName=fullName.getText().toString().trim();
                String pUn=userName.getText().toString().trim();
                String pEm=Email.getText().toString().trim();
                String pPwd=passWord.getText().toString().trim();

                if(pUn!=null){
                HelperClass helperClass=new HelperClass(pName,pUn,pEm,pPwd);
                reference.child(pUn).setValue(helperClass);
                }

                Intent intent=new Intent(SignUp.this,Login.class);
                startActivity(intent);
            }
        });
        signupLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SignUp.this,Login.class);
                startActivity(intent);
            }
        });




    }
}