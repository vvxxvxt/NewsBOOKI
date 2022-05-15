package com.newbook.newsbooki;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int listnumber = 10;
    private ListData[] listData = new ListData[listnumber];
    public MainActivity(){
        ListInput();
    }
    private void ListInput() {
        for(int i=0;i<10;i++) {
            listData[i] = new ListData("2022학년도 1학기 폐강공고 및 폐강과목 수강신청자 수강정정 안내" + i, "작성일:2022.05.04");
        }
    }

    private MenuData[] menuData = {
            new MenuData(R.drawable.rect43, R.drawable.notice_pressed, R.drawable.noticeicon_pressed),
            new MenuData(R.drawable.rect44, R.drawable.news, R.drawable.newsicon),
            new MenuData(R.drawable.rect44, R.drawable.schedule, R.drawable.scheduleicon),
            new MenuData(R.drawable.rect44, R.drawable.my, R.drawable.myicon)
    };

    private ListView mList;
    private com.newbook.newsbooki.MyAdapter mAdapter;
    private GridView menuView;
    private MyMenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = (ListView) findViewById(R.id.list);
        mAdapter = new com.newbook.newsbooki.MyAdapter(this, listData);
        mList.setAdapter(mAdapter);

        //클릭시 리스너

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), BodyText.class);
                startActivity(intent);
            }
        });



        menuView = (GridView) findViewById(R.id.menu);
        menuAdapter = new MyMenuAdapter(this, menuData);
        menuView.setAdapter(menuAdapter);

    }
}