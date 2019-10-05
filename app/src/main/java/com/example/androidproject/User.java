package com.example.androidproject;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {


    public String email;
    public String password;
    public String name;
    public String mobilenumber;
    public String dateofbirth;


    public User() {
    }
    public User(String email,String password,String dob,String Name,String Mobile){
        this.email=email;
        this.password=password;
        this.dateofbirth=dob;
        this.name=Name;
        this.mobilenumber=Mobile;
    }

    public void setEmail_Id(String email_Id) {
        email = email_Id;
    }

    public void setDateofbirth(String Date_Of_Birth) {
        dateofbirth = Date_Of_Birth;
    }

    public void setMobile_Number(String mobile_Number) {
        mobilenumber = mobile_Number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
