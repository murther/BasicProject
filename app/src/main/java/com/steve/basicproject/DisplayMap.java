package com.steve.basicproject;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Steve on 10/21/2014.
 */
public class DisplayMap extends FragmentActivity{
    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.maps);
    }
}
