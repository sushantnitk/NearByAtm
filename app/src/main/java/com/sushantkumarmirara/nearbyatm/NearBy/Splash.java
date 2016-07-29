package com.sushantkumarmirara.nearbyatm.NearBy;

import android.app.Activity;
import android.app.ProgressDialog;
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
import com.sushantkumarmirara.nearbyatm.Utils.LocationSettingDialog;

/**
 * Created by sushantkumar on 18/7/16.
 */
public class Splash extends Activity implements FetchFromServerUser,FindCurrentLocationUser {
    WifiManager wifiManager;
    LocationManager locationManager;
    ImageView splash;
    String longitude,latitude;
    ProgressDialog dialog;
    public Splash() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        dialog = new ProgressDialog(this);
        splash = (ImageView)findViewById(R.id.splash);

        setContentView(R.layout.splash_activity);
        dialog.setMessage(getString(R.string.getting_location));
        dialog.setIndeterminate(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(true);
        dialog.show();
        new FindCurrentLocationTask(this, this).execute();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || !wifiManager.isWifiEnabled()) {
            LocationSettingDialog.enableLocationSetting(this);
        }
    }

    @Override
    public void onPreFetch() {

    }

    @Override
    public void onFetchCompletion(String string, int id) {

    }

    @Override
    public void onFindLocationCompletion(Location L) {

        longitude = String.valueOf(L.getLongitude());
        latitude = String.valueOf(L.getLatitude());
        Intent intent = new Intent(Splash.this,MainActivity.class);
        intent.putExtra("Longitude",longitude);
        intent.putExtra("Latitude",latitude);
        startActivity(intent);
    }
}
