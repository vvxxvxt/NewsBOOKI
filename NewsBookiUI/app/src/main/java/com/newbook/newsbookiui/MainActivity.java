package com.newbook.newsbookiui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private MenuData[] menuData = {
            new MenuData(R.drawable.rect43, R.drawable.notice_pressed, R.drawable.noticeicon_pressed),
            new MenuData(R.drawable.rect44, R.drawable.news, R.drawable.newsicon),
            new MenuData(R.drawable.rect44, R.drawable.schedule, R.drawable.scheduleicon),
            new MenuData(R.drawable.rect44, R.drawable.my, R.drawable.myicon)
    };

    private int data = 10;
    private ListView mList;
    private MyAdapter mAdapter;
    private GridView menuView;
    private MyMenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = (ListView) findViewById(R.id.list);
        mAdapter = new MyAdapter(this, data);
        mList.setAdapter(mAdapter);

        menuView = (GridView) findViewById(R.id.menu);
        menuAdapter = new MyMenuAdapter(this, menuData);
        menuView.setAdapter(menuAdapter);

    }
}