package com.sushantkumarmirara.nearbyatm.NearBy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sushantkumarmirara.nearbyatm.Utils.FetchFromServerUser;

import java.util.List;

/**
 * Created by sushantkumar on 5/8/16.
 */
public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> implements FetchFromServerUser {
    static Context c;
    List<Integer> placeList;
    LayoutInflater layoutInflater;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public MainActivityAdapter(Context context,List<Integer> places) {
        super();
        c=context;
        placeList = places;
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }


    @Override
    public void onPreFetch() {

    }

    @Override
    public void onFetchCompletion(String string, int id) {

    }


}
