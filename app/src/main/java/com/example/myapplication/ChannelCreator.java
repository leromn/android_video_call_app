package com.example.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.myapplication.databinding.ActivityChannelCreatorBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChannelCreator extends AppCompatActivity {

    EditText channelName;
    Button createButton;
    private ActivityChannelCreatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_creator);
        binding = ActivityChannelCreatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        createButton=findViewById(R.id.chCreate);
        channelName=findViewById(R.id.chName);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createChannel();
            }
        });

    }

    public void createChannel()  {

        String type="create";
        String cnString=channelName.getText().toString();
        BkWorker bkWorker=new BkWorker(this);
        bkWorker.execute(type,cnString);



    }

}