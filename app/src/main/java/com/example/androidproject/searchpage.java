package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class searchpage extends AppCompatActivity {
//    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchpage);
        Spinner countries = (Spinner) findViewById(R.id.Countries);
        ArrayAdapter<CharSequence> country = ArrayAdapter.createFromResource(this,
                R.array.country, android.R.layout.simple_spinner_item);
        country.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countries.setAdapter(country);
        Spinner courses = (Spinner) findViewById(R.id.Course);
        ArrayAdapter<CharSequence> course = ArrayAdapter.createFromResource(this,
                R.array.course, android.R.layout.simple_spinner_item);
        course.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courses.setAdapter(course);
    }

    public void search(View view) {
        Spinner country = findViewById(R.id.Countries);
        String count = country.getSelectedItem().toString();
        Spinner course = findViewById(R.id.Course);
        String cou = course.getSelectedItem().toString();
        TextView gre = findViewById(R.id.gre);
        int GRE = Integer.parseInt(gre.getText().toString());
        Choices.country = count;
        Choices.course = cou;
        Choices.GRE =GRE;
        Intent i = new Intent(this,CollegeDisplay.class);
        startActivity(i);
    }
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//    }
}
