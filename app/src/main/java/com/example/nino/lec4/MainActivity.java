package com.example.nino.lec4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<chModel> channelList = new ArrayList<>();
        for(int i = 0; i < data.channels.length; i ++ ) {
            chModel newchannel = new chModel(data.channels[i], data.aida[i], data.images[i], data.detail[i]);
            channelList.add(newchannel);
        }
 //       ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this , R.layout.list_item_layout, data.channels );
 //       ListView listview = (ListView) findViewById(R.id.list);
 //       listView.setAdapter(arrayAdapter);

        adapter adapteri = new adapter(this , channelList);
 //       listview.setAdapter(adapteri);



    }
}
