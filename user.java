package com.example.softteamapp;

public class user {
    String name,email,phone,pass,cpass;
    public user()
    {

    }

public user(String name, String email,String phone,String pass,String cpass){
    this.name=name;
    this.email=email;
    this.phone=phone;
    this.pass=pass;
    this.cpass=cpass;

}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCpass() {
        return cpass;
    }

    public void setCpass(String cpass) {
        this.cpass = cpass;
    }
}
