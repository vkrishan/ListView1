package com.example.vkrishan.listview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        lv = (ListView)findViewById(R.id.listsview);

        // Data
        String[] values = new String[]{"Mercury","Venus","Earth","Mars", "Jupiter","Saturn","Uranus","Neptune", "Pluto"};

        final ArrayList<String> planetsLists = new ArrayList<String>();
        for(int i=0; i<values.length; i++){
            planetsLists.add(values[i]);
        }

        // Call and Stick Adapter to ListView
        final Adapter adapt = new Adapter(this, android.R.layout.simple_list_item_1, planetsLists);
                            //           context      rowView                          arraylist
        lv.setAdapter(adapt);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        planetsLists.remove(item);
                        adapt.notifyDataSetChanged();
                        view.setAlpha(1);
                    }
                });

            }
        });

    }
}
