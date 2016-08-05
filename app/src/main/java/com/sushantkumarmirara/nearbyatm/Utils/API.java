package com.sushantkumarmirara.nearbyatm.Utils;

/**
 * Created by sushantkumar on 29/7/16.
 */

import android.net.Uri;
import android.util.Log;
public class API {

    public static String getAllAtm(String longitude,String latitude){
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(Constants.SCHEME)
                .encodedAuthority(Constants.GOOGLE_PLACES_URL)
                .appendQueryParameter("location",latitude + "," + longitude)
                .appendQueryParameter("radius",String.valueOf(Constants.SEARCH_RADIUS))
                .appendQueryParameter("type",Constants.ATM)
                .appendQueryParameter("key",Constants.PLACES_API_KEY);
        Log.d("API For ATM :",builder.build().toString());
        return builder.build().toString();
    }

    public static String getAllSchools(String longitude,String latitude){
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(Constants.SCHEME)
                .encodedAuthority(Constants.GOOGLE_PLACES_URL)
                .appendQueryParameter("location",latitude + "," + longitude)
                .appendQueryParameter("radius",String.valueOf(Constants.SEARCH_RADIUS))
                .appendQueryParameter("type",Constants.SCHOOL)
                .appendQueryParameter("key",Constants.PLACES_API_KEY);
        Log.d("API For ATM :",builder.build().toString());
        return builder.build().toString();
    }
    public static String getAllHospitals(String longitude,String latitude){
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(Constants.SCHEME)
                .encodedAuthority(Constants.GOOGLE_PLACES_URL)
                .appendQueryParameter("location",latitude + "," + longitude)
                .appendQueryParameter("radius",String.valueOf(Constants.SEARCH_RADIUS))
                .appendQueryParameter("type",Constants.HOSPITALS)
                .appendQueryParameter("key",Constants.PLACES_API_KEY);
        Log.d("API For ATM :",builder.build().toString());
        return builder.build().toString();
    }

    public static String getAllRestaurant(String longitude,String latitude){
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(Constants.SCHEME)
                .encodedAuthority(Constants.GOOGLE_PLACES_URL)
                .appendQueryParameter("location",latitude + "," + longitude)
                .appendQueryParameter("radius",String.valueOf(Constants.SEARCH_RADIUS))
                .appendQueryParameter("type",Constants.RESTAURANT)
                .appendQueryParameter("key",Constants.PLACES_API_KEY);
        Log.d("API For ATM :",builder.build().toString());
        return builder.build().toString();
    }
    public static String getAllBusStops(String longitude,String latitude){
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(Constants.SCHEME)
                .encodedAuthority(Constants.GOOGLE_PLACES_URL)
                .appendQueryParameter("location",latitude + "," + longitude)
                .appendQueryParameter("radius",String.valueOf(Constants.SEARCH_RADIUS))
                .appendQueryParameter("type",Constants.BUS_STOP)
                .appendQueryParameter("key",Constants.PLACES_API_KEY);
        Log.d("API For ATM :",builder.build().toString());
        return builder.build().toString();
    }
}
