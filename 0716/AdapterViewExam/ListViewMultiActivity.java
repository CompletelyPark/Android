package com.jica.adapterviewexam;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewMultiActivity extends AppCompatActivity {

    ArrayList<String> city;
    ListView listView;
    ArrayAdapter<String> adapter;

    Button btn_add, btn_del;
    EditText edit_text_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        LinearLayout rootLayout = findViewById(R.id.rootLayout);
        rootLayout.setBackgroundColor(Color.GRAY);
        listView = findViewById(R.id.listView);
        btn_add = findViewById(R.id.btn_add);
        btn_del = findViewById(R.id.btn_del);
        edit_text_id = findViewById(R.id.edit_text_id);

//      original data for listview
        city = new ArrayList<String>();
        city.add("Jeonju");
        city.add("Iksan");
        city.add("Buan");
        city.add("Gunsan");
        city.add("Namwon");


//      adapter make connect listView
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_multiple_choice,city);
        listView.setAdapter(adapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

//      button click event handler
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              trim() - 문장 앞 뒤의 공백 제거
                String cityname = edit_text_id.getText().toString().trim();
                if (cityname.equals("")||cityname.length()<1)
                    return;

//              add to original data
                city.add(cityname);

//              input data delete
                edit_text_id.setText("");

//              original data change to adapter
//              changed screen reflect listView
                adapter.notifyDataSetChanged();
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray pos = listView.getCheckedItemPositions();
                Log.d("Tag",pos.toString());
//                {0= true, 1= true, 2= false, 3= true, 4= false}

//              선택한 항목이 하나 라도 있으면
                if(pos.size()!=0){
//                  선택한 항목의 뒤에서부터 제거
                    for(int i  = city.size()-1;i>=0;i--){
//                      원본에서 항목 제거
                        if(pos.get(i)) city.remove(i);
                    }
                }
//              현재의 listView 에서 선택 항목의 흔적 제거
                listView.clearChoices();
//              adapter 에게 현재의 원본 데이터 내용을 반영 시켜서
//              listView 의 항목 뷰를 다시 보이기
                adapter.notifyDataSetChanged();


            }
        });
    }
}