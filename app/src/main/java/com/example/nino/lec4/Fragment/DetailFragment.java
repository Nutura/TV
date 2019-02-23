package com.example.nino.lec4.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.nino.lec4.data;

public class DetailFragment extends Fragment {
    public int getItemIndex(){
        return getArguments().getInt("index" , 0);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ScrollView detailScroller = new ScrollView(getActivity());
        TextView detailText =  new TextView(getActivity());
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4 , getActivity().getResources().getDisplayMetrics());
        detailText.setPadding(padding,padding,padding,padding);
        detailScroller.addView(detailText);

        detailText.setText(data.detail[getItemIndex()]);

        return detailScroller;
    }
}
