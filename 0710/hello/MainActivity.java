package com.jica.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

// 내부에 들어가는 모든 파일의 이름은 소문자로 작성해야 한다
public class MainActivity extends AppCompatActivity {
//  activity의 객체로 만들어진 직후에 호출되는 method가 oncreate() 이다

    Button btnWebBrowser, btnCallPhone2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//      activity 의 화면 구성 내용을 res/ layout/ activity_main.xml 파일에 저장
//      이 내용을 실행 시켜서 memory 에 모두 widget 이고
//      그 중 root tag 에 widget 을 현재의 activity 와 연결 시켜서 등록
//      최종적으로 화면에 보여 지는 내용이 된다

        setContentView(R.layout.activity_main);

//      findViewById() method를 사용해 xml layout file의 내용이 객체로 만들어 졌을 때
//      해당 객체의 참조값을 얻는다.
//      단, findViewByid() method는 setContentView() method 이후에 사용해야 한다
        btnWebBrowser = findViewById(R.id.btnWebBrowser);
        btnCallPhone2 = findViewById(R.id.btnCallPhone2);

//      버튼 객체의 이벤트 핸들러 설정
        btnWebBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onWebButton(view);
            }
        });

        btnCallPhone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCallButton(view);
            }
        });
    }



//      버튼을 클릭했을 때 수행 할 동작, 즉 이벤트 핸들러를 설정할 수 있다
//      버튼 계열의 위젯은 단순한 방법으로 지정할 수 있다
//      화면 디자인을 하는 xml layout file 에서
//      버튼 객체의 onclick 속성값에 method 이름을 작성한다
    public void onButton(View view) {
        Toast.makeText(this, "button clicked", Toast.LENGTH_LONG).show();
    }

    //  웹브라우저 호출 버튼을 클릭했을 때 호출 되는 이벤트 핸들러 method
    public void onWebButton(View view) {
//      webBrowser app call - 하나의 activity
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://naver.com"));
//      activity 직접 작동이 아닌 activity 호출해줘 부탁
        startActivity(myIntent);
    }

    //  call button clicked method
    public void onCallButton(View view) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1000-1000"));
        startActivity(myIntent);
    }
}
/*
    실제 화면 내용이 보여질 때는 onResume() method가 동작한 직후에 나타난다
    onCreate 가 끝났다고 해서 나오는게 아니라 연결시켜 주는 것
    activity_lifecycle.png 참조
 */
