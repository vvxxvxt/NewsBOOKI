package com.newbook.newsbookiui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MyAdapter extends BaseAdapter {

    private int data;
    private Context ctx;
    public MyAdapter(Context ctx,int data) {
        this.data = data;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return data;
    }

    @Override
    public Object getItem(int i) {
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

        return convertView;
    }

}
