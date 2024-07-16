package com.jica.layoutexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

//  ui object reference field
    Button btn_linear,btn_constraint, btn_frame, btn_Table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//      xml layout file inflation - activity connect
        setContentView(R.layout.activity_main);

//      get reference value
        btn_linear = findViewById(R.id.btn_linear);
        btn_constraint = findViewById(R.id.btn_constraint);
        btn_frame = findViewById(R.id.btn_frame);
        btn_Table = findViewById(R.id.btn_Table);


//      if button click, event handler object create
//      ButtonHandler buttonHandler = new ButtonHandler();

//      mainActivity 에서 View.OnclickListener interface 를 구현 시 event handler setting
        btn_linear.setOnClickListener(this);
        btn_constraint.setOnClickListener(this);
        btn_frame.setOnClickListener(this);
        btn_Table.setOnClickListener(this);

    }

    public void onClick(View view) {
        int curId = view.getId();
        Intent intent = null;
        String msg = null;

        if(curId == R.id.btn_constraint){
            msg = "ConstraintLayout button clicked";
            intent = new Intent(getApplicationContext(), ConstraintLayoutActivity.class);
        }

        else if (curId == R.id.btn_linear) {
            msg = "LinearLayout button clicked";
            intent = new Intent(getApplicationContext(), LinearLayoutActivity.class);
        }

        else if (curId == R.id.btn_frame){
            msg = "FrameLayout button clicked";
            intent = new Intent(getApplicationContext(), FrameLayoutActivity.class);
        }
        else if (curId == R.id.btn_Table){
            msg = "TableLayout button clicked";
            intent = new Intent(getApplicationContext(), TableLayoutActivity.class);
        }

        if(intent!=null) {
            Log.d("Tag",msg);
            startActivity(intent);
        }
    }

//  if button click, activate event handler
//    class ButtonHandler implements View.OnClickListener{
//
//        @Override
//        public void onClick(View view) {
////          인자로 전달된 버튼 객체의 id 값으로 버튼을 구분
//            int curId = view.getId();
//
//            if(curId == R.id.btn_constraint){
//
//                Log.d("TAG","ConstraintLayout button clicked");
//                Intent intent = new Intent(getApplicationContext(), ConstraintLayoutActivity.class);
//                startActivity(intent);
//            }
//
//            else if (curId == R.id.btn_linear) {
//                Log.d("TAG","LinearLayout button clicked");
//
////              호출 할 activity 를 명시적 으로 저장 하는 intent 객체 생성
////              public intent(Context packageContext, Class <?> cls)
////                                                                  호출 하고 싶은 Activity 의 class 정보 호출
////              activity 에서 activity 호출
//                Intent intent = new Intent(getApplicationContext(), LinearLayoutActivity.class);
//                startActivity(intent);
//            }
//            else if (curId == R.id.btn_frame){
//                Log.d("TAG","FrameLayout button clicked");
//
////                Intent intent = new Intent(getApplicationContext(), FrameLayoutActivity.class);
////                startActivity(intent);
//            }
//
//        }
//    }
}

