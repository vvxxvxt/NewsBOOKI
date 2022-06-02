package com.newbook.newsbooki;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private ListData[] listData;
    private int listnumber;
    public static String TextTitle = "기본 제목";
    public static String TextDate = "기본 날짜";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ListLayout();//메인 리스트뷰
        this.InitializeLayout();//사이드메뉴
    }

    public void ListLayout() {
        listnumber = 30;//임시로 넣은 리스트 항목 갯수
        listData = new ListData[listnumber];
        ListInput();

        ListView mList = (ListView) findViewById(R.id.list);
        MyAdapter mAdapter = new MyAdapter(this, listData);
        mList.setAdapter(mAdapter);

        //리스트 클릭시, 글내용이 나오게 하는 리스너
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextTitle = listData[position].listTitle;
                TextDate = listData[position].listDate;
                Intent intent = new Intent(getApplicationContext(), BodyText.class);
                startActivity(intent);
            }
        });
    }

    private void ListInput() {//임시로 내용넣음, 나중에 수정하면됨.
        for (int i = 0; i < listnumber; i++) {
            listData[i] = new ListData("2022학년도 1학기 폐강공고 및 폐강과목 수강신청자 수강정정 안내" + i, "작성일:2022.05.04");
        }
    }

    //여기부터 사이드메뉴바+상단네비바 관련임 수정할시 다른데거도 같이 수정
    //왜냐면 네비바를 화면 넘어갈때마다 다시 쓰는거로 해서 다른데도 이코드가 다 들가야됨
    public void InitializeLayout() {
        //toolBar를 통해 App Bar 생성
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("학사공지");
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        //앱이름이 툴바에 나오는데, 그걸 제거함.
        //일단 toolbar.setTitle으로 제거가 아니라 글자를 바꾸고 xml에서 글자색 변경으로 되게 했음

        //앱바 좌측에 메뉴버튼 추가
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu_button);

        DrawerLayout drawLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);



        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawLayout,
                toolbar,
                R.string.open,
                R.string.closed
        );

        drawLayout.addDrawerListener(actionBarDrawerToggle);



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menuitem1:
                        Toast.makeText(getApplicationContext(), "학사공지", Toast.LENGTH_SHORT).show();
                    case R.id.menuitem2:
                        Toast.makeText(getApplicationContext(), "My", Toast.LENGTH_SHORT).show();
                    case R.id.menuitem3:
                        Toast.makeText(getApplicationContext(), "뉴스", Toast.LENGTH_SHORT).show();
                    case R.id.menuitem4:
                        Toast.makeText(getApplicationContext(), "시간표", Toast.LENGTH_SHORT).show();
                }
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}