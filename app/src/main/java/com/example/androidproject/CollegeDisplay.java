package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CollegeDisplay extends FragmentActivity implements OnMapReadyCallback {
    private static final String TAG = "activity_collegedisplay";
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collegedisplay);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        universitydisplayer();
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

    }
    public void universitydisplayer(){
        String country = Choices.country;
        String course = Choices.course;
        int GRE = Choices.GRE;
        if(country.equals("United States Of America")){
            if(course.equals("Master of Science")){
                if(GRE > 300){
                    LatLng mit = new LatLng(42.359760,-71.091430);
                    mMap.addMarker(new MarkerOptions().position(mit).title("Massachusetts Institute of Technology").snippet("Master of Science 330"));
                    LatLng cit = new LatLng(34.135880,-118.132260);
                    mMap.addMarker(new MarkerOptions().position(cit).title("California Institute of Technology ").snippet(" Master of Science 240"));
                    LatLng hu = new LatLng(41.790050,-87.599810);
                    mMap.addMarker(new MarkerOptions().position(hu).title("University of Chicago").snippet("Master of Science  290"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(mit));
                }
                else if(300 > GRE ){
                    LatLng cit = new LatLng(34.135880,-118.132260);
                    mMap.addMarker(new MarkerOptions().position(cit).title("California Institute of Technology ").snippet(" Master of Science 270"));
                    LatLng hu = new LatLng(41.790050,-87.599810);
                    mMap.addMarker(new MarkerOptions().position(hu).title("University of Chicago ").snippet(" Master of Science \n 290"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(hu));
                }
            }
        }
//        mMap.addMarker()
    }
}
