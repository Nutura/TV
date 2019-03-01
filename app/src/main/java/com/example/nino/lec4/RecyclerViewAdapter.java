package com.example.nino.lec4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<chModel> mChannelList;
    private Context mContext;


    public RecyclerViewAdapter (Context Context, ArrayList<chModel> ChanneLlist){
        Context = mContext;
        ChanneLlist = mChannelList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup , int viewType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_layout, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Log.d(TAG, "onBindViewHolder called");

        chModel chmodel = (chModel) getItem(position);

        viewHolder.text.setText(chModel.class.getName());
        //On click listener for fragment
/*        viewHolder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));
                Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return mChannelList.size();
    }


    public Object getItem(int position) {
        return mChannelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView icon;
        TextView text;
        RelativeLayout parentlayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
            parentlayout = itemView.findViewById(R.id.recycleLayout);
        }
    }
}
