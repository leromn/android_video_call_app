package com.example.myapplication.ui;



//registration class





public  class HelperClass {
    public static String name,userName,email,password;

    public HelperClass(String name, String userName, String email, String password) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class Invitation {
    String from, to, channelName, token;

    public Invitation(String fr, String t, String ch, String tkn) {
        this.from = fr;
        this.to = t;
        this.channelName = ch;
        this.token = tkn;
    }
}


//recycle re


