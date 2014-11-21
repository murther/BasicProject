package com.steve.basicproject;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Steve on 10/21/2014.
 */
public class DisplayMap extends FragmentActivity {
    //private final LatLng currentLocation= new LatLng(0,0);
    private GoogleMap googleMap;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.maps);
        setUpMapifNeeded();
        //map22 = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
    }
    private void setUpMapifNeeded(){
        if(googleMap ==null){
            googleMap =((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            if(googleMap!=null){
                setUpMap();
            }
        }
    }
    private void setUpMap(){
        googleMap.setMyLocationEnabled(true);
        LocationManager locationManager= (LocationManager)getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria,true);
        Location myLocation = locationManager.getLastKnownLocation(provider);
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        double latitude= myLocation.getLatitude();
        double longitude = myLocation.getLongitude();
        LatLng latLng = new LatLng(latitude, longitude);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(20));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(latitude,longitude)).title("YOu are here!"));

    }
}
