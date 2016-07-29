package com.sushantkumarmirara.nearbyatm.Utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;

import com.sushantkumarmirara.nearbyatm.NearBy.Splash;
import com.sushantkumarmirara.nearbyatm.R;


public class LocationSettingDialog {

    public static void enableLocationSetting(final Context context){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(R.layout.location_accuracy_dialog);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                WifiManager manager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
                manager.setWifiEnabled(true);

                Intent gpsSettings = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(gpsSettings);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent backToSplash = new Intent(context, Splash.class);
                context.startActivity(backToSplash);
            }
        });
        builder.setCancelable(false);
        builder.create();

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}