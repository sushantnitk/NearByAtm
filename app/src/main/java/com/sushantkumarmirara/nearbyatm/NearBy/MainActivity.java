package com.sushantkumarmirara.nearbyatm.NearBy;

/**
 * Created by sushantkumar on 18/7/16.
 */

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sushantkumarmirara.nearbyatm.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    String latitude,longitude;
    RecyclerView recyclerView;
    MainActivityAdapter adapter;
    List<Places> list;
    ImageView coverPic;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latitude=(getIntent().getStringExtra("Latitude"));
        longitude = (getIntent().getStringExtra("Longitude"));
        initCollapsingToolbar();
        list = new ArrayList<>();
        recyclerView =(RecyclerView)findViewById(R.id.recycler_view);
        adapter= new MainActivityAdapter(this,list,latitude,longitude);
        coverPic = (ImageView)findViewById(R.id.backdrop);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        preparePlaces();
        try {
            Glide.with(this).load(R.drawable.bookcover).into(coverPic);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    public void preparePlaces(){
        int [] places = new int[]{
                R.drawable.hospital,
                R.drawable.restaurant,
                R.drawable.schools,
                R.drawable.busstop,
                R.drawable.movies,
                R.drawable.atm
        };
        Places p = new Places("Hospital",places[0],0);
        list.add(p);
        p= new Places("Restaurant",places[1],1);
        list.add(p);
        p = new Places("Schools",places[2],2);
        list.add(p);
        p= new Places("BusStop",places[3],3);
        list.add(p);
        p = new Places("Movies",places[4],4);
        list.add(p);
        p = new Places("Atm",places[5],5);
        list.add(p);
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(" ");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;

                }
            }
        });
    }

        

        /**
         * Converting dp to pixel
         */
        private int dpToPx(int dp) {
            Resources r = getResources();
            return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
        }

    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

}


