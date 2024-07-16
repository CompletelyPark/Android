package com.jica.layoutinflation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_add, btn_remove;

    LinearLayout rootLinearLayout;

    TextView text_title, text_grade, text_date;

    int index=0;

    int thumbnail[] = {
            R.drawable.thumbnail_web1,R.drawable.thumbnail_web2,
            R.drawable.thumbnail_web3,R.drawable.thumbnail_web4,
            R.drawable.thumbnail_web5,R.drawable.thumbnail_web6,
            R.drawable.thumbnail_web7,R.drawable.thumbnail_web8,
            R.drawable.thumbnail_web9,R.drawable.thumbnail_web10
    };
    String titles[] ={
            "제목1","제목2",
            "제목3","제목4",
            "제목5","제목6",
            "제목7","제목8",
            "제목9","제목10",
    };

    float grade[] = {
            9.99f,9.98f,
            9.97f,9.96f,
            9.95f,9.94f,
            9.93f,9.92f,
            9.91f,9.90f,
    };


    String date[] = {
            "2024.07.14","2024.07.13",
            "2024.07.12","2024.07.11",
            "2024.07.10","2024.07.09",
            "2024.07.08","2024.07.07",
            "2024.07.06","2024.07.05",
    };

    ArrayList<Webtoon> webtoons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//      아래의 method 는 activity_main.xml 의 모든 내용을 객체로 만들어서
//      전체 화면 으로 activity 와 연결 시킨다
//      우리가 필요할 때 직접 inflation 을 수행할 수 있다
//      화면 일부의 내용만 미리 xml layout file 로 작성해 놓고
//      필요한 시점 에서 전개해 activity 에
//      연결 addView(), 제거 removeView() 시켜서 사용 한다
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_remove = findViewById(R.id.btn_remove);
        rootLinearLayout = findViewById(R.id.rootLinearLayout);

//      if click view add button, event handler set

//      xml file inflation
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              webtoon.xml 내용을 전개 시키기 위해 전개 객체 (LayoutInflater) 을 구한다
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//              inflation
                LinearLayout webtoonLinearLayout = (LinearLayout) layoutInflater.inflate(R.layout.webtoon,
                                                                        rootLinearLayout, false);

                ImageView imageViewWeb = webtoonLinearLayout.findViewById(R.id.imageViewWeb);
                imageViewWeb.setImageResource(thumbnail[index]);

                text_title = webtoonLinearLayout.findViewById(R.id.text_title);
                text_title.setText(titles[index]);

                text_grade = webtoonLinearLayout.findViewById(R.id.text_grade);
                text_grade.setText(grade[index]+"");

                text_date = webtoonLinearLayout.findViewById(R.id.text_date);
                text_date.setText(date[index]);


                index = (++index >= 10) ? 0 : index;
//              전개 한 View (webtoonLinearLayout) 을 rootLinearLayout 에 추가 한다
//              Ui object를 찾아 필요한 값을 설정한다
                rootLinearLayout.addView(webtoonLinearLayout);


//                View.inflate(R.layout.webtoon,);

            }
        });

        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              마지막 widget 제거
//                rootLinearLayout.removeViewAt(rootLinearLayout.getChildCount()-1);

//              2번째 widget 제거, widget 본인 제거 방지
                if(rootLinearLayout.getChildCount()>=3)
                    rootLinearLayout.removeViewAt(2);

            }
        });


    }

//    public void makedata(){
//        if(webtoons!= null){
//            webtoons.clear();
//            webtoons = null;
//        }
//
//        webtoons = new ArrayList<Webtoon>();
//        Webtoon webtoon1 = new Webtoon(R.drawable.thumbnail_web1,9.99f,"제목 1","2024-07.15");
//        webtoons.add(webtoon1);
//        webtoon1 = new Webtoon(R.drawable.thumbnail_web2,9.98f,"제목 2","2024-07.14");
//        webtoons.add(webtoon1);
//        webtoon1 = new Webtoon(R.drawable.thumbnail_web3,9.97f,"제목 3","2024-07.13");
//        webtoons.add(webtoon1);
//
//
//    }
}