package com.example.root.gmailexample.ListAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.gmailexample.POJO.ItemObject;
import com.example.root.gmailexample.R;

import java.util.ArrayList;

/**
 * Created by root on 20/8/16.
 */

public class CustomListAdapter extends BaseAdapter {Context context;
    ArrayList<ItemObject> listMovies;

    public CustomListAdapter(Context context,ArrayList<ItemObject> listMovies){
        this.context = context;
        this.listMovies = listMovies;
    }

    @Override
    public int getCount() {
        return listMovies.size();
    }

    @Override
    public Object getItem(int position) {
        return listMovies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        private TextView textViewtitle;
        private ImageView imageViewIcon;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewtitle = (TextView) convertView.findViewById(R.id.textViewTitle);
            viewHolder.imageViewIcon = (ImageView) convertView.findViewById(R.id.imageIcon);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ItemObject movies = listMovies.get(position);
        String title = movies.getTitle();
        int icon = movies.getImageIcon();
        viewHolder.textViewtitle.setText(title+"");
        viewHolder.imageViewIcon.setImageResource(icon);
        return convertView;
    }
}
