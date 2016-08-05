package com.sushantkumarmirara.nearbyatm.NearBy;

/**
 * Created by sushantkumar on 18/7/16.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;

import com.sushantkumarmirara.nearbyatm.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Double latitude,longitude;
    GridView gridView;
    RecyclerView adapter;
    List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latitude=Double.parseDouble(getIntent().getStringExtra("Latitude"));
        longitude = Double.parseDouble(getIntent().getStringExtra("Longitude"));
        list = new ArrayList<>();
        list.add(R.drawable.hospital);
        list.add(R.drawable.restaurant);
        list.add(R.drawable.schools);
        list.add(R.drawable.busstop);
        list.add(R.drawable.atm);
        list.add(R.drawable.movies);


    }
}
