package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class searchpage extends AppCompatActivity {
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

    }
}
