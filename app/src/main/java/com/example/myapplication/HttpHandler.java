package com.example.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHandler {
    static class GOVERNOR{
        public static String ChannelName="nn",Token="8789",UserName;
    }

    //    static Channel currentChannel;
    private static final String POST_URL = "http://198.168.43.81:8080/second2/serveIt";


    public static boolean createChannel(String channelName) throws IOException {
//        Channel channel=new Channel();

        String queryString = "channelName="+channelName;//"+& action=createChannel"
        URL obj = new URL(POST_URL);
        HttpURLConnection con;
        con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
//        con.setRequestProperty("User-Agent", USER_AGENT);

        if(con!=null) {
            System.out.println(con);
        }
        // For POST only - START

        OutputStream os = con.getOutputStream();
        os.write(queryString.getBytes());
        os.flush();
        os.close();
        // For POST only - END

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            GOVERNOR.ChannelName=channelName;
            GOVERNOR.Token=response.toString();

//            System.out.println(response.toString());
        } else {
            System.out.println("channel creation did not work.");
        }
//        currentChannel=channel;
        return true;
    }

    static void invitePerson(String recieverId){

//        get token and ch name after creating the channel
        if ((GOVERNOR.ChannelName!= null )&&( GOVERNOR.Token!= null )) {


        }
//        Channel.ChannelName,Channel.Token

    }

    static void joinChannel(String channelName,String token){

//        change the agora variables to the objects values
        GOVERNOR.ChannelName=channelName;
        GOVERNOR.Token=token;

//        start the agora video call activity
    }

}