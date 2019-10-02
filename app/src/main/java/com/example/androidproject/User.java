package com.example.androidproject;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {


    public String Email_Id;
    public String Password;
    public String Name;
    public String Mobile_Number;
    public String Date_Of_Birth;

    public User() {
    }

    public User(String email, String password, String name, String mobilenumber, String dob) {
        this.Email_Id = email;
        this.Name = name;
        this.Password = password;
        this.Mobile_Number = mobilenumber;
        this.Date_Of_Birth = dob;
    }

}
