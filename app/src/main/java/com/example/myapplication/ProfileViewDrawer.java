package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.ui.ChannelInfo;
import com.example.myapplication.ui.HelperClass;
import com.example.myapplication.ui.listDptr;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ActivityProfileViewDrawerBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class ProfileViewDrawer extends AppCompatActivity {

    Button join,create;
    TextView profileName,profileEmail;
//    my imports

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityProfileViewDrawerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProfileViewDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarProfileViewDrawer.toolbar);
        binding.appBarProfileViewDrawer.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "panel visibility toggled", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_profile_view_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
//my code st@rt
        //fetch list from fireDB
        ArrayList<ChannelInfo> list=new ArrayList<>();
        list.add(new ChannelInfo("demoCh@nnel_1","ffd","fdfd","fdfd"));

        FirebaseDatabase database;
        DatabaseReference reference;
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("channellist");


        if(reference!=null){
            list.add(new ChannelInfo("found_refereence","ffd","fdfd","fdfd"));
        }
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                   for(DataSnapshot dsp:snapshot.getChildren()){
                       String x="j",y="j",z="j",m="j";
                       x=dsp.child("channelname").getValue().toString();
                       y=dsp.child("sender").getValue().toString();
                       z=dsp.child("time").getValue().toString();
                       m=dsp.child("token").getValue().toString();

                       list.add(new ChannelInfo(x,y,z,m));
                   }
                }
                else{
                    list.add(new ChannelInfo("noch@nnelfound","ffd","fdfd","fdfd"));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("canceled operation");
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listDptr adapter = new listDptr(list,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);






//        profile dr@wer d@t@
        View view=navigationView.getHeaderView(0);
        profileName=view.findViewById(R.id.ProfileName);
        profileEmail=view.findViewById(R.id.ProfileEmail);

        showUserData();

//        home buttons & Recycler view
        create=findViewById(R.id.createButton);
        join=findViewById(R.id.joinButton);

        BkWorker bkWorker=new BkWorker(this);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ProfileViewDrawer.this,ChannelCreator.class);
                startActivity(intent);
            }
        });
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bkWorker.execute("join");
            }
        });
//        end
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile_view_drawer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_profile_view_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    void showUserData(){
        Intent intent=getIntent();
        String em=intent.getStringExtra("email");
        String nm=intent.getStringExtra("fullName");
        System.out.println(em+nm);


        profileEmail.setText(em);
        profileName.setText(nm);

    }

}