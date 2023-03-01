package com.example.myapplication.ui;

public class ChannelInfo {
   public String channelname,
           sender ="1", time ="2", token;

    public ChannelInfo(String channelname, String sender, String time, String token) {
        this.channelname = channelname;
        this.sender = sender;
        this.time = time;
        this.token = token;
    }

    public ChannelInfo() {
    }

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
