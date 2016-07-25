package com.sushantkumarmirara.nearbyatm.Utils;

/**
 * Created by sushantkumar on 18/7/16.
 */
public interface FetchFromServerUser {
    void onPrefetch();
    void onFetchCompletion(String string,int id);
}
