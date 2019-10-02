package com.example.androidproject;

import java.text.SimpleDateFormat;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

public class detailspage extends AppCompatActivity {
    String email;
    private String password;
//    String uID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailspage);
        Bundle b = getIntent().getExtras();
        String email = b.getString("username");
        this.email=email;
        String password = b.getString("password");
        this.password=password;
//        this.uID = b.getString("uId");
    }


    public void submit(View view) {
        // Write a message to the database
        FirebaseDatabase data = FirebaseDatabase.getInstance();
        DatabaseReference path = data.getReference();
        EditText name = findViewById(R.id.nametext);
        EditText mobile = findViewById(R.id.phonetext);
        CalendarView DOB = findViewById(R.id.DOB);
        String Name = name.getText().toString();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        String date = df.format(DOB.getDate());
        String Mobile = mobile.getText().toString();
        User user = new User(email,password,Name,Mobile,date);
//        final String userId=getUID();
//        path.child("userinfo").child(uID).setValue(user);
        path.child("userinfo").push().setValue(user);
        Intent intent = new Intent(detailspage.this,MainActivity.class);
        startActivity(intent);
    }
}