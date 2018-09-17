package com.example.dc.pushnotificationsfirebasecm;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DebugActivity extends AppCompatActivity {
    ListView listViewDebug;
    ArrayAdapter adapter;
    //////////////////////
    //
    // Write the name of the new activity  in this array
    //////////////////////

    String Activities[] ={
            "Debug activity"


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);

        listViewDebug = (ListView) findViewById(R.id.listViewDebug);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Activities);

        listViewDebug.setAdapter(adapter);
        listViewDebug.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /////////////////////////
                //
                //Add the new activity navigation to the end of this switch
                // case n+1:
                // startActivity(new Intent(DebugActivity.this,name_of_activity.class));break;
                //This will add the activity to the debuglist
                /////////////////////////
                switch(position){
                    case 0:
                        startActivity(new Intent(DebugActivity.this,Debug.class));break;


                }

            }
        });

    }
}
