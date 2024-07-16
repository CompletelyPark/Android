package com.jica.firstandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;

    Button btn_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//      화면 구성 내용을 별도의 xml 파일로 작성해 놓고 실행 시점에서 모든 구성 요소를 객체로 생성해 이를 activity 에 연결 시킨다
//      setContentView(int);

//      java code: R.__ res 폴더를 가리킨다
//      ex) R.layout.activity_main - layout 파일의 activity_main 파일
//      res 폴더 내부 에서 다른 자원을 지정할 때 ex) @drawable/res 이름, @layout/res 이름
//      R.drawable.cola

//      실행 시점 에서 activity_main 의 모든 것을 객체로 만든다
        setContentView(R.layout.activity_main);

//      프로그램 실행 도중 xml로 구성한 내용을 참조할 필요성이 있을 때는 어떻게 해야 할까
        tvTitle = findViewById(R.id.tvTitle);
//      객체 값 수정
        tvTitle.setText("ㅎㅇㅎㅇ");


    }

    public void onButtonClicked(View v) {
//        Log.d("Tag","button clicked");
        Toast.makeText(this,"확인 1 버튼",Toast.LENGTH_LONG).show();
    }

    public void onButtonClicked1(View v) {
        Intent myintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://naver.com"));
        startActivity(myintent);
    }

    public void onButtonClicked2(View v) {
       Intent myintent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1000-1000"));
        startActivity(myintent);
    }
}


/*
      match_parent: 부모 위젯의 크기 만큼
      wrap_content: 현재 위젯의 내용 만큼
      숫자로 값 지정: 단위 기술 (권장은 dp) (inchi, pixel, mm, ...)
      dp 단위는 해상도에 따라서 적용이 된다
      
      activity 가 제일 먼저 동작 하는 게 onCreate 이다

      android:layout_margin: 부모 위젯 이나 다른 위젯 과의 간격
 */
