package com.example.nino.lec4;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<chModel> mChannelList = new ArrayList<>();
    private Context mContext;


    public RecyclerViewAdapter (Context Context, ArrayList<chModel> ChanneLlist){
        mContext = Context;
        mChannelList = ChanneLlist;
    }
    @NonNull
    public ViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
  //      View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view, viewGroup, false);
        View view = inflater.inflate(R.layout.recycle_view, container, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder called");

        chModel chmodel = (chModel) getItem(position);

        holder.text.setText(chmodel.getChannel());
        holder.icon.setImageResource(chmodel.getImage());

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
        LinearLayout parentlayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.imageRecycle);
            text = itemView.findViewById(R.id.channelRecycle);
            parentlayout = itemView.findViewById(R.id.recycleLayout);
        }
    }
}
