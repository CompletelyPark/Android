package com.jica.layoutexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FrameLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_page1, btn_page2, btn_page3;
    LinearLayout page1_layout,page2_layout,page3_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        btn_page1 = findViewById(R.id.btn_page1);
        btn_page2 = findViewById(R.id.btn_page2);
        btn_page3 = findViewById(R.id.btn_page3);

        page1_layout = findViewById(R.id.page1_layout);
        page2_layout = findViewById(R.id.page2_layout);
        page3_layout = findViewById(R.id.page3_layout);

        btn_page1.setOnClickListener(this);
        btn_page2.setOnClickListener(this);
        btn_page3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        int curId = view.getId();
//        if(curId==R.id.btn_page1)

//        view 가 상위 button 이 하위 라서 형변환 해야함
        Button curButton = (Button)view;

        if (curButton==btn_page1) {
            page1_layout.setVisibility(View.VISIBLE);
            page2_layout.setVisibility(View.INVISIBLE);
            page3_layout.setVisibility(View.INVISIBLE);
        }

        else if(curButton==btn_page2){
            page1_layout.setVisibility(View.INVISIBLE);
            page2_layout.setVisibility(View.VISIBLE);
            page3_layout.setVisibility(View.INVISIBLE);
        }

        else if (curButton==btn_page3) {
            page1_layout.setVisibility(View.INVISIBLE);
            page2_layout.setVisibility(View.INVISIBLE);
            page3_layout.setVisibility(View.VISIBLE);
        }
    }
}