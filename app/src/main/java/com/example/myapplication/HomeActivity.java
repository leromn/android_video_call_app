package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.ui.HelperClass;
import com.example.myapplication.ui.listDptr;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ActivityHomeBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    Button join,create;
    TextView profileName,profileEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        create=findViewById(R.id.createButton);
        join=findViewById(R.id.joinButton);

//        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
//        Query checkUserDatabase=reference.orderByChild("userName").equalTo(getIntent().getStringExtra("userName"));
////        profileName.setText();
////        profileEmail.setText();
//
////        make helper class object
////        form an array
//        ArrayList<HelperClass> myListData=new ArrayList<>();
//
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        listDptr adapter = new listDptr(myListData,this);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
//
//        BkWorker bkWorker=new BkWorker(this);
//        create.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent=new Intent(HomeActivity.this,ChannelCreator.class);
//                startActivity(intent);
//            }
//        });
//        join.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                bkWorker.execute("join");
//            }
//        });


//my code ending
    }


}