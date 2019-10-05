package com.example.androidproject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import android.Manifest;
import android.util.Size;
import android.graphics.Matrix;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureConfig;
import androidx.camera.core.Preview;
import androidx.camera.core.PreviewConfig;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LifecycleOwner;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.TextureView;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.type.Date;

public class detailspage extends AppCompatActivity {

    public String dob;
//    String uID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailspage);
        Intent i = getIntent();
//        Bundle b = getIntent().getExtras();
        String email = i.getStringExtra("username");
        TextView e =  (TextView)findViewById(R.id.email);
        e.setText(email);
        String password = i.getStringExtra("password");
        TextView p = (TextView) findViewById(R.id.password);
        p.setText(password);
//        this.uID = b.getString("uId");
        PreviewConfig previewConfig = new PreviewConfig.Builder().build();
        ImageCaptureConfig imageCaptureConfig =
                new ImageCaptureConfig.Builder().build();

        ImageCapture imageCapture = new ImageCapture(imageCaptureConfig);
        Preview preview = new Preview(previewConfig);

        final TextureView textureView = findViewById(R.id.view_finder);

        preview.setOnPreviewOutputUpdateListener(new Preview.OnPreviewOutputUpdateListener() {
            @Override
            public void onUpdated(Preview.PreviewOutput previewOutput) {
                textureView.setSurfaceTexture(previewOutput.getSurfaceTexture());
            }
        });

        CameraX.bindToLifecycle((LifecycleOwner) this, preview, imageCapture);

    }

    public void submit(View view) {
        // Write a message to the database
        FirebaseDatabase data = FirebaseDatabase.getInstance();
        DatabaseReference path = data.getReference("/userinfo");
        TextView e = (TextView) findViewById(R.id.email);
        TextView p = (TextView) findViewById(R.id.password);
        EditText name = findViewById(R.id.nametext);
        EditText mobile = findViewById(R.id.phonetext);
        CalendarView DOB = (CalendarView) findViewById(R.id.DOB);
//        Calendar c = Calendar.getInstance();
        String Name = name.getText().toString();
        final SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
//        Date date = new Date(DOB);
        String dob = df.format(DOB.getDate());
//        String dob = df.format();
//        CalendarView DOB = (CalendarView) findViewById(R.id.DOB);


//            @Override
//            public void onSelectedDayChange(CalendarView arg0, int year, int month,
//                                            int date) {
//                TextView dob = (TextView) findViewById(R.id.date_of_birth);
//                dob.setText(month + "/"+ date +"/"+year);
//            }
//        });
        TextView d = (TextView) findViewById(R.id.date_of_birth);
        String Mobile = mobile.getText().toString();
        String email= e.getText().toString();
        String password = p.getText().toString();
//        String dob = d.getText().toString();
//        String password = this.password;
//        String dob = this.dob;
//        User user = new User();
//        user.setEmail_Id(email);
//        user.setDateofbirth(dob);
//        user.setPassword(password);
//        user.setName(Name);
//        user.setMobile_Number(Mobile);
//        final String userId=getUID();
//        path.child("userinfo").child(uID).setValue(user);
//        path.child("userinfo").push();
        String finaltry = "{ \"Date_Of_Birth\" : " + dob + ", \"Name\" : " + Name
                + ", \"Mobile_Number\" : " + Mobile + "}";
//        Map<String,User> user = new HashMap<>();
//        user.put(email,new User(email,password,dob,Name,Mobile));
        path.push().setValue(finaltry);
        Intent intent = new Intent(detailspage.this,MainActivity.class);
        startActivity(intent);
    }

    public void clickpic(View view) {

    }
}