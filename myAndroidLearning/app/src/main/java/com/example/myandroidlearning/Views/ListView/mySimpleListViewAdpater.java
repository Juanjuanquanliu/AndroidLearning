package com.example.myandroidlearning.Views.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myandroidlearning.R;

import java.util.List;

public class mySimpleListViewAdpater extends BaseAdapter {

    private Context context;
    private int resouceId;
    public List<myFruit> viewHolderList;
    public mySimpleListViewAdpater(Context ctx,int textResourceId, List<myFruit> objects){
        context = ctx;
        resouceId = textResourceId;
        viewHolderList = objects;
    }
    @Override
    public int getCount() {
        return viewHolderList.size();
    }

    @Override
    public Object getItem(int i) {
        return (Object) viewHolderList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    static class ViewHolder{
        public ImageView imageView;
        public TextView title,date,content;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        myFruit holder = (myFruit) getItem(i);
        View v;
        ViewHolder viewHolder = new ViewHolder();
        if(view == null){
            v = LayoutInflater.from(context).inflate(resouceId,null);
            viewHolder.imageView = (ImageView) v.findViewById(R.id.simple_img);
            viewHolder.title = (TextView) v.findViewById(R.id.simple_title);
            viewHolder.date = (TextView) v.findViewById(R.id.simple_date);
            viewHolder.content = (TextView) v.findViewById(R.id.simple_content);
            v.setTag(viewHolder);
        }else {
            v = view;
            viewHolder = (ViewHolder) v.getTag();

        }
        viewHolder.imageView.setImageResource(holder.getImageId());
        viewHolder.title.setText(holder.getSimTitle());
        viewHolder.date.setText(holder.getSimDate());
        viewHolder.content.setText(holder.getSimContent());

        return v;
    }
}
