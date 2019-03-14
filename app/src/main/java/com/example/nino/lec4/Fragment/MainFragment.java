package com.example.nino.lec4.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import com.example.nino.lec4.DetailsActivity;
import com.example.nino.lec4.MainActivity;
import com.example.nino.lec4.R;
import com.example.nino.lec4.RecyclerViewAdapter;
import com.example.nino.lec4.chModel;
import com.example.nino.lec4.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainFragment extends ListFragment {
    private boolean isDualPanel;
    private int currentItemIndex = 0;
    static ArrayList<chModel> channelList = new ArrayList<>();


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        ArrayList<chModel> channelList = new ArrayList<>();

        View detaildFrame = getActivity().findViewById(R.id.contents);
        isDualPanel = detaildFrame!= null && detaildFrame.getVisibility() == View.VISIBLE;

        for(int i = 0; i < data.channels.length; i ++ ) {
            chModel newchannel = new chModel(data.channels[i], data.aida[i], data.images[i], data.detail[i]);
            channelList.add(newchannel);
        }
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<10;i++){
            HashMap<String, String> channels = new HashMap<String,String>();
            channels.put("chan", data.channels[i]);
            channels.put("id", Integer.toString (data.aida[i]));
            channels.put("image", Integer.toString(data.images[i]));
            channels.put("det", "detail : " + data.detail[i]);

            aList.add(channels);
        }
        
        String[] from = { "chan","id","image" };
        int[] to = { R.id.channel,R.id.aida,R.id.image};
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.list_item_layout, from, to);
        setListAdapter(adapter);

        if(savedInstanceState != null){
            currentItemIndex = savedInstanceState.getInt("Our choice ", 0);
        }
        if(isDualPanel){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            //showDetails();
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Our Choice" , currentItemIndex);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
        super.onListItemClick(l, v, position, id);
    }

    private void showDetails(int index){
        currentItemIndex = index;

        if(isDualPanel){
            DetailFragment detailsFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.contents);
            if(detailsFragment == null || detailsFragment.getItemIndex() != index){
                detailsFragment = DetailFragment.newInstance(index);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.contents, detailsFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();

            }

        }else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), DetailsActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }
    }


    public static void deleteAdd(boolean show) {
        if(show){
            Log.d("remove list","in function remove list");
            channelList.clear();
        }
    }




}
