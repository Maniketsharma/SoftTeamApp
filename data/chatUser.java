package com.example.softteam.data;
public class chatUser {
    public String mobile,name,message,date,time;

    public chatUser(String mobile, String name, String message, String date) {
        this.mobile = mobile;
        this.name = name;
        this.message = message;
        this.date = date;
        this.time = time;
    }

    public String getMobile() {
        return mobile;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
