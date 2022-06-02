package com.newbook.newsbooki;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;//리스트에서 누르면 나오는 공지?본문
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class BodyText extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bodytext);

        this.InitializeLayout();//사이드메뉴

        textChange();

    }

    public void textChange(){
        //제목수정
        TextView title = (TextView)findViewById(R.id.bodyTitle);
        title.setText(MainActivity.TextTitle);
        //날짜수정
        TextView date = (TextView)findViewById(R.id.bodyDate);
        date.setText(MainActivity.TextDate);

        //내용수정, 이건 따로 받아와야될거같음 위치는 있으니까
        TextView content = (TextView)findViewById(R.id.bodyContent);
        content.setText("기본 내용");
    }

    //여기부터 사이드메뉴바+상단네비바 관련임 수정할시 다른데 있는거도 같이 수정
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
