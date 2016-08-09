package com.sushantkumarmirara.nearbyatm.NearBy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sushantkumarmirara.nearbyatm.R;
import com.sushantkumarmirara.nearbyatm.Utils.API;
import com.sushantkumarmirara.nearbyatm.Utils.FetchFromServerTask;
import com.sushantkumarmirara.nearbyatm.Utils.FetchFromServerUser;

import java.util.List;

/**
 * Created by sushantkumar on 5/8/16.
 */
public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> implements FetchFromServerUser {
    static Context c;
    List<Places> placeList;
    LayoutInflater layoutInflater;
    String latitude,longitude;


    public class ViewHolder extends RecyclerView.ViewHolder {
       public TextView title;
       public ImageView place;
        public ViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            place=(ImageView)itemView.findViewById(R.id.place_nearby);
        }
    }

    public MainActivityAdapter(Context context,List<Places> places,String latitude,String longitude) {
        super();
        c=context;
        placeList = places;
        this.longitude = longitude;
        this.latitude = latitude;
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_places,parent,false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Places place = placeList.get(position);
        holder.title.setText(place.getName());
        Glide.with(c).load(place.getPlaces()).into(holder.place);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (place.getPosition()){
                    case 1:
                        new FetchFromServerTask(MainActivityAdapter.this,1).execute(API.getAllHospitals(longitude,latitude));
                    case 2:
                        new FetchFromServerTask(MainActivityAdapter.this,2).execute(API.getAllRestaurant(longitude,latitude));
                    case 3:
                        new FetchFromServerTask(MainActivityAdapter.this,3).execute(API.getAllSchools(longitude,latitude));
                    case 4:
                        new FetchFromServerTask(MainActivityAdapter.this,4).execute(API.getAllBusStops(longitude,latitude));
                    case 5:
                        new FetchFromServerTask(MainActivityAdapter.this,5).execute(API.getAllAtm(longitude,latitude));
                }
            }
        });
    }


    @Override
    public int getItemCount() {

        return placeList.size();
    }


    @Override
    public void onPreFetch() {

    }

    @Override
    public void onFetchCompletion(String string, int id) {

    }


}
