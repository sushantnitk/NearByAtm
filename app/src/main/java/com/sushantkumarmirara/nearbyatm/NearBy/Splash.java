package com.sushantkumarmirara.nearbyatm.NearBy;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import com.sushantkumarmirara.nearbyatm.R;
import com.sushantkumarmirara.nearbyatm.Utils.FetchFromServerUser;
import com.sushantkumarmirara.nearbyatm.Utils.FindCurrentLocationUser;

/**
 * Created by sushantkumar on 18/7/16.
 */
public class Splash extends Activity implements FetchFromServerUser,FindCurrentLocationUser {
    WifiManager wifiManager;
    LocationManager locationManager;
    public Splash() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        setContentView(R.layout.splash_activity);

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
    public void onPrefetch() {

    }

    @Override
    public void onFetchCompletion(String string, int id) {

    }

    @Override
    public void onFindLocatioCompletion(Location L) {

    }
}
