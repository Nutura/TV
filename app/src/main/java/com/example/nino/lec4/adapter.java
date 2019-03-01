package com.example.nino.lec4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class adapter  extends BaseAdapter {
    private ArrayList<chModel> ChannelList;
    private Context context;

    public adapter (Context context , ArrayList<chModel> ChannelList ){
        this.context = context;
        this.ChannelList = ChannelList;
    }

    @Override
    public int getCount() {
        return ChannelList.size();
    }

    @Override
    public Object getItem(int position) {
        return ChannelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView;
        ViewHolder holder = null;

        if (convertView == null){
            itemView  = View.inflate(context, R.layout.list_item_layout , null);
            ImageView icon = (ImageView) itemView.findViewById(R.id.image);
            TextView channel = (TextView) itemView.findViewById(R.id.channel);
            TextView aidi = (TextView) itemView.findViewById(R.id.aida);


            holder = new ViewHolder();



            holder.icon = icon;
            holder.channel = channel;
            holder.aida = aidi;


            itemView.setTag(holder);
        }else{
            itemView = convertView;
            holder = (ViewHolder) itemView.getTag();
        }

        chModel chmodel = (chModel) getItem(position);

        holder.icon.setImageResource(chmodel.getImage());
        holder.channel.setText(chmodel.getChannel());
        holder.aida.setText( "" + chmodel.getAidi());

        return itemView;
    }
    private class ViewHolder {
        ImageView icon;
        TextView channel, aida;

    }
}
