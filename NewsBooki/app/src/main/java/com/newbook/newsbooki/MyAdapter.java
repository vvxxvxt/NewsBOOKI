package com.newbook.newsbooki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    //private String list[];
    private com.newbook.newsbooki.ListData[] data;
    private Context ctx;

    /*
    public MyAdapter(Context ctx,int data) {
        this.data = data;
        this.ctx = ctx;
    }

     */


    public MyAdapter(Context ctx, com.newbook.newsbooki.ListData[] data) {
        this.data = data;
        this.ctx = ctx;
    }


    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        //return list[2];
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(ctx);
            convertView = inflater.inflate(R.layout.notice_list, parent, false);
        }

        TextView listTitle  = (TextView)convertView.findViewById(R.id.list_title);
        listTitle.setText(data[position].listTitle);
        TextView listDate = (TextView) convertView.findViewById(R.id.list_date);
        listDate.setText(data[position].listDate);
        /*
        //getItem으로 내용 가져오기 위한 코드
        list = new String[2];
        list[0] = data[position].listTitle;
        list[1] = data[position].listDate;

         */

        return convertView;
    }

}
