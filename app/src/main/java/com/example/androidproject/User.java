package com.example.androidproject;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {


    public String Email;
    public String Name;
    public String Mobile_Number;
    public String Date_Of_Birth;


    public User() {
    }
    public User(String email,String dob,String Name,String Mobile){
        Email=email;
        Date_Of_Birth=dob;
        this.Name=Name;
        Mobile_Number=Mobile;
    }
}
