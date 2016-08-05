package com.sushantkumarmirara.nearbyatm.Utils;

import android.os.Build;

/**
 * Created by sushantkumar on 29/7/16.
 */
public class Constants {
    public static final String SCHEME = "https";
    public static final String ATM = "atm";
    public static final String HOSPITALS = "hospital";
    public static final String SCHOOL = "school";
    public static final String RESTAURANT = "restaurant";
    public static final String BUS_STOP = "bus_stop";

    public static final String GOOGLE_PLACES_URL = "maps.googleapis.com/maps/api/place/nearbysearch/json";
    public static final int SEARCH_RADIUS = 1000;
    public static final String PLACES_API_KEY = "AIzaSyBg-iwzAjavEUVV9hOQUr0JljZHL7XFRkQ";
    public static final int STATUS_NETWORK_DISCONNECTED = 0;
    public static final int STATUS_LOCATION_NOT_UPDATING = 1;
    public static final int LAST_PING_TIME_EXCEEDS_THRESHOLD = 2;
    public static final int LAST_PING_SUCCESS = 3;
    public static final int DISCONNECTED_FROM_SERVER = 4;
}
