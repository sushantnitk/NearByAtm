package com.sushantkumarmirara.nearbyatm.NearBy;

/**
 * Created by Pandey on 06-08-2016.
 */
public class Places {
    private String name;
    private int thumbnail;
    private int position;
    public Places(){}

    public Places(String name,int thumbnail,int position){
        this.name=name;
        this.thumbnail = thumbnail;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
