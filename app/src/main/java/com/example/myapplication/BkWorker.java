package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.myapplication.ui.ChannelInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;

public class BkWorker extends AsyncTask<String, Void, String> {

    Context context;
    ChannelInfo channel=new ChannelInfo();
    String result="";
    String type="";



    public BkWorker(Context ctx) {
        this.context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        type= params[0];

        if (type.equals("create")) {

            try {
                URL url = new URL("http://192.168.43.81:8080/second2/serveIt");
                HttpURLConnection urlConnection = null;
                BufferedReader reader = null;
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                urlConnection.connect();

                OutputStream os = urlConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));


                channel.channelname = params[1];
                String queryString = "channelName="+channel.channelname +"&&action=createChannel";

                bufferedWriter.write(queryString);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();


                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                urlConnection.disconnect();

                channel.token =result;
                return result;

            } catch (MalformedURLException | ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if (type=="join"){

            try {
                URL url = new URL("http://192.168.43.81:8080/second2/serveIt");
                HttpURLConnection urlConnection = null;
                BufferedReader reader = null;
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                urlConnection.connect();

                OutputStream os = urlConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                String queryString = "action=join";

                bufferedWriter.write(queryString);
                bufferedWriter.flush();
                bufferedWriter.close();

                os.close();
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    result += line;
                }
                String[] cont=result.split("-");
                channel.channelname =cont[0];
                channel.token =cont[1];

                bufferedReader.close();
                inputStream.close();
                return result;
            }catch (Exception e){
                System.out.println(e);
            }

        }

        return null;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onPostExecute(String result) {
        Intent myIntent = new Intent(context, MainActivity.class);
        if(result!=""){
            if (type=="join"){

            myIntent.putExtra("channelName",channel.channelname);
            myIntent.putExtra("token", channel.token);
            context.startActivity(myIntent);

            }else if(type=="create"){
                Date dt=new Date();
                long time=dt.getTime();

                FirebaseDatabase database;
                DatabaseReference reference;

                database= FirebaseDatabase.getInstance();
                reference=database.getReference("channellist");
                reference.child(channel.channelname).setValue(channel);

            myIntent.putExtra("channelName", channel.channelname);
            myIntent.putExtra("token", channel.token);
            context.startActivity(myIntent);


            }

        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}