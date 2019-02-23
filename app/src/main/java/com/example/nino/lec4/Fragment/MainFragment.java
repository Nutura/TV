package com.example.nino.lec4.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import com.example.nino.lec4.R;
import com.example.nino.lec4.chModel;
import com.example.nino.lec4.data;

import java.util.ArrayList;

public class MainFragment extends ListFragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<chModel> channelList = new ArrayList<>();
        for(int i = 0; i < data.channels.length; i ++ ) {
            chModel newchannel = new chModel(data.channels[i], data.aida[i], data.images[i], data.detail[i]);
            channelList.add(newchannel);

            setListAdapter( new  ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, data.channels));
//            Fragment listview = (Fragment) findViewById(R.id.mainFragment;
//            listView.setAdapter(arrayAdapter);

            //       ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this , R.layout.list_item_layout, data.channels );
            //       ListView listview = (ListView) findViewById(R.id.list);
            //       listView.setAdapter(arrayAdapter);




        }
    }
}
