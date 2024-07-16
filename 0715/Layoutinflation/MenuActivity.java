package com.jica.layoutinflation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {

    LinearLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        container = findViewById(R.id.container);
        Button button = findViewById(R.id.btn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                
//              xml layout inflate attach parent view
//              true false 차이
//              false 일때만 내가 원할 때 추가
//              여러번 반복 하면 부모뷰 (container 에 동일한 id를 가진 위젯이 계속 추가 되므로)
//              findViewById() 사용시 첫번째 추가된 위젯만 찾아 온다
                inflater.inflate(R.layout.sub1,container,true);
                CheckBox checkBox = container.findViewById(R.id.checkbox);
                checkBox.setText("로딩되었어요");
            }
        });

    }
}