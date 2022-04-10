package com.newbook.newsbooki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MyMenuAdapter extends BaseAdapter {

    private com.newbook.newsbooki.MenuData[] data;
    private Context ctx;
    public MyMenuAdapter(Context ctx, com.newbook.newsbooki.MenuData[] data) {
        this.ctx = ctx;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
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
            convertView = inflater.inflate(R.layout.menu_bottom, parent, false);
        }

        ImageView background = (ImageView) convertView.findViewById(R.id.background);
        background.setImageResource(data[position].background);
        ImageView letter = (ImageView) convertView.findViewById(R.id.letter);
        letter.setImageResource(data[position].letter);
        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        icon.setImageResource(data[position].icon);

        return convertView;
    }

}
