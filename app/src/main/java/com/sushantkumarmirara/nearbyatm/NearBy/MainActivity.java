package com.sushantkumarmirara.nearbyatm.NearBy;

/**
 * Created by sushantkumar on 18/7/16.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.sushantkumarmirara.nearbyatm.R;


public class MainActivity extends AppCompatActivity {
    Double latitude,longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latitude=Double.parseDouble(getIntent().getStringExtra("Latitude"));
        longitude = Double.parseDouble(getIntent().getStringExtra("Longitude"));



    }
}
