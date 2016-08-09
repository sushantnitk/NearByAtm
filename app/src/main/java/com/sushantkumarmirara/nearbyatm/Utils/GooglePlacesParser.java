package com.sushantkumarmirara.nearbyatm.Utils;

import android.util.Log;

import com.sushantkumarmirara.nearbyatm.NearBy.Places;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Pandey on 08-08-2016.
 */
public class GooglePlacesParser {
    String JSON;
    String type;

    ArrayList<GooglePlacesBean> placesList;

    public GooglePlacesParser(String JSON){
        this.JSON = JSON;
    }

    public ArrayList<GooglePlacesBean>getPlacesList(String JSON){

        placesList = new ArrayList<>();
        GooglePlacesBean p = new GooglePlacesBean();
         try{
             JSONObject main = new JSONObject(JSON);
             JSONArray placedetails = main.getJSONArray("results");
             for(int i=0;i<placedetails.length();i++){
                 JSONObject location = placedetails.getJSONObject(i).getJSONObject("geometry").getJSONObject("location");
                 String types = placedetails.getJSONObject(i).getJSONArray("types").getString(1);
                 boolean open = placedetails.getJSONObject(i).getJSONObject("opening_hours").getBoolean("open_now");
                 Double rating = placedetails.getJSONObject(i).getDouble("rating");
                 String name = placedetails.getJSONObject(i).getString("name");
                 String vicinity = placedetails.getJSONObject(i).getString("vicinity");
                 String photoreference= placedetails.getJSONObject(i).getJSONArray("photos").getString(2);
                 String lat = location.getString("lat");
                 String lng = location.getString("lng");
                 p.setName(name);
                 p.setLatitude(lat);
                 p.setLongitude(lng);
                 p.setOpenNow(open);
                 p.setVicinity(vicinity);
                 p.setType(types);
                 p.setRating(rating);
                 p.setPhotoreference(photoreference);
                 placesList.add(p);
             }
         }catch (JSONException ex){
             Log.e("GooglePlaceParser","Error while Parsing",ex);
         }
        return placesList;
    }



}
