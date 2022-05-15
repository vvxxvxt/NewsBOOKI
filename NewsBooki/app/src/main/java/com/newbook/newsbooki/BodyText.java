package com.newbook.newsbooki;

import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;//리스트에서 누르면 나오는 공지?본문

public class BodyText extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bodytext);
    }
    /*
    public void BodyText(){
        TextView title = (TextView)findViewById(R.id.bodyTitle);
        title.setText("내용2");
    }
     */
}
