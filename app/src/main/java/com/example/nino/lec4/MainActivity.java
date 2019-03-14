package com.example.nino.lec4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.support.v7.widget.LinearLayoutManager;


import com.example.nino.lec4.Fragment.MainFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<chModel> channelList = new ArrayList<>();
        for (int i = 0; i < data.channels.length; i++) {
            chModel newchannel = new chModel(data.channels[i], data.aida[i], data.images[i], data.detail[i]);
            channelList.add(newchannel);
        }

        adapter adapteri = new adapter(this, channelList);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, channelList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //       listview.setAdapter(adapteri);

        Button listViewButton = findViewById(R.id.listViewButton);
        listViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainFragment.deleteAdd(true);
            }
        });
    }
}
