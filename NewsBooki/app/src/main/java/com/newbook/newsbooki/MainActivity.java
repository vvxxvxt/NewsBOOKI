package com.newbook.newsbooki;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListData[] listData = {
            new ListData("2022학년도 1학기 폐강공고 및 폐강과목 수강신청자 수강정정 안내", "작성일:2022.05.04"),
            new ListData("2022학년도 1학기 폐강공고 및 폐강과목 수강신청자 수강정정 안내2", "작성일:2022.05.05"),
            new ListData("2022학년도 1학기 폐강공고 및 폐강과목 수강신청자 수강정정 안내3", "작성일:2022.05.06")
    };

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

        menuView = (GridView) findViewById(R.id.menu);
        menuAdapter = new MyMenuAdapter(this, menuData);
        menuView.setAdapter(menuAdapter);

    }
}