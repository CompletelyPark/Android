package com.jica.layoutexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//      화면 구성을 사용자 가 java code 로 직접 작성 해야 한다
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
        linearLayout.setLayoutParams(params);

        LinearLayout.LayoutParams params1 =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params1.gravity= Gravity.CENTER_HORIZONTAL;
        params1.topMargin = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,30,this.getResources().getDisplayMetrics()
        );

        params1.bottomMargin = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,30,this.getResources().getDisplayMetrics()
        );


        LinearLayout.LayoutParams params2 =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params2.leftMargin = (int)TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,20,this.getResources().getDisplayMetrics()
        );

        params2.rightMargin = (int)TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,20,this.getResources().getDisplayMetrics()
        );


        TextView textView = new TextView(this);
        textView.setText(R.string.text2);
        textView.setTextSize(24);           // 단위는 pixel 단위
        textView.setTextColor(0xFFE53935);
//        textView.setTextColor(Color.RED);
//        textView.setTextColor(Color.rgb(255,0,0);
//        textView.setTextColor(ContextCompt.getColor(this,R.Color.my_red);
        textView.setLayoutParams(params1);

        Button button = new Button(this);
        button.setText("Button");
        button.setBackgroundColor(0xFF00FFFF);
        button.setLayoutParams(params2);

        linearLayout.addView(textView);
        linearLayout.addView(button);

        setContentView(linearLayout);
/*
        처음에 실행할 때 앱이 종료 되는 현상이 생겼다
        manifests file 이나 MainActivity file 에서 크게 문제가 없었다
        <activity
            android:name=".LinearLayoutActivity"
            android:exported="false" />           <-- 요거도 제대로 해놈
        gpt한테 물어 봐서 수정된 코드를 봤는데 크게 다른 점이 없었다
        문제는 setContentView 가 2번 정의 됐었다
        한번씩 더 확인 하는 버릇을 기르자
*/

//      현재의 화면 구성과 똑같은 내용 으로 java code 로 화면 구성을 해보자

//        setContentView(R.layout.activity_linear_layout);

/*
       위처럼 Java code 로 직접 ui object 를 생성해 화면을 구성 하면 복잡 하므로
       미리 별도의 xml file 로 화면 구성을 한 후 필요한 시점 에서 inflation 해서 사용 한다
 */
    }
}