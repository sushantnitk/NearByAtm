package com.sushantkumarmirara.nearbyatm.NearBy;

import java.util.List;

/**
 * Created by Pandey on 06-08-2016.
 */
public class Places {
    private String name;
    private int position;
    private int places;

    public Places(String name,int places,int position){
        this.name = name;
        this.position= position;
        this.places = places;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }
}
