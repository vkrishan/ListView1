package com.example.vkrishan.listview1;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.HashMap;
import java.util.List;

/**
 * Created by vkrishan on 7/5/17.
 */

public class Adapter extends ArrayAdapter<String> {

    // Keep ke value pairs of row id and value in it.
    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public Adapter(Context context, int textViewResourceId, List<String> objects){
        super(context, textViewResourceId, objects);
        for(int i=0; i<objects.size(); ++i){
            mIdMap.put(objects.get(i), i);
        }
    }

    public long getItemId(int position) {
        String item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }



}
