package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.ui.HelperClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Login extends AppCompatActivity {
    EditText userName,password;
    Button login;

//    made the function assignment in the xml layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName=findViewById(R.id.userName2);
        password=findViewById(R.id.password2);
        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUser();
            }
        });



    }
   public void checkUser(){
        String username=userName.getText().toString().trim();
        String pass=password.getText().toString().trim();

       DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase=reference.orderByChild("userName").equalTo(username);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    String nameFromDb=snapshot.child(username).child("name").getValue(String.class);
                    String userNameFromDb=snapshot.child(username).child("userName").getValue(String.class);
                    String emailFromDb=snapshot.child(username).child("email").getValue(String.class);
                    String passwordFromDb=snapshot.child(username).child("password").getValue(String.class);



                    Intent intent=new Intent(Login.this,ProfileViewDrawer.class);
                    intent.putExtra("userName", userNameFromDb);
                    intent.putExtra("fullName", nameFromDb);
                    intent.putExtra("email", emailFromDb);
                        startActivity(intent);

                }
                else{
                    userName.setText("invalid user");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                userName.setText("DatabaseError error");
            }
        });

    }
}