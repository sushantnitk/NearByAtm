package com.sushantkumarmirara.nearbyatm.NearBy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.sushantkumarmirara.nearbyatm.R;
import com.sushantkumarmirara.nearbyatm.Utils.FetchFromServerUser;
import com.sushantkumarmirara.nearbyatm.Utils.FindCurrentLocationTask;
import com.sushantkumarmirara.nearbyatm.Utils.FindCurrentLocationUser;

/**
 * Created by sushantkumar on 18/7/16.
 */
public class Splash extends Activity implements FetchFromServerUser,FindCurrentLocationUser {
    WifiManager wifiManager;
    LocationManager locationManager;
    ImageView splash;
    String longitude,latitude;
    public Splash() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        RotateAnimation anim = new RotateAnimation(0f, 350f, 15f, 15f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(700);
        splash = (ImageView)findViewById(R.id.splash);
        splash.startAnimation(anim);
        setContentView(R.layout.splash_activity);
        new FindCurrentLocationTask(this, this).execute();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onPreFetch() {

    }

    @Override
    public void onFetchCompletion(String string, int id) {

    }

    @Override
    public void onFindLocationCompletion(Location L) {
        splash.setAnimation(null);
        longitude = String.valueOf(L.getLongitude());
        latitude = String.valueOf(L.getLatitude());
        Intent intent = new Intent(Splash.this,MainActivity.class);
        intent.putExtra("Longitude",longitude);
        intent.putExtra("Latitude",latitude);
        startActivity(intent);
    }
}
