package com.jica.adapterviewexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//  ListView 에 의해서 표현될 원본 데이터 - String[], ArrayList<String> 으로 표현 한다
    String[] strmenu = {
        "Simple listView",
        "ListView singleChoice",
        "ListView multiChoice",
        "Custom listView",
        "Spinner",
        "GridView",
        "Expandable listView",
    };

//  원본 data 를 listView 에 widget 과 함께 구성해 항목 view 를 만들 어서 제공 해주는 Adapter
//  String list or simple String doing using
    ArrayAdapter adapter;

//  ui object
    ListView Menulist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      search listView
        Menulist = findViewById(R.id.Menulist);

//      create Adapter
//      1st - Context context
//      2nd - listView 에 의해 화면에 보여 지는 항목 뷰의 xml layout id
//      3rd - original data
//      android system 에서 제공 하는 R.layout.simple_list_item_1 xml file
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,strmenu);

//      link adapter and listView
        Menulist.setAdapter(adapter);

//      when listView's specific select, activating event handler set
        Menulist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                AdapterView<?> adapterView - listView's reference value
//                View view - clicked category view's reference value
//                int i - 화면에 보여진 원본 데이터 의 순서
//                long l - clicked category view's id value

//                toast up
                String msg = "select object " + i + " num " + strmenu[i];
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();

                Intent intent = null;
                switch (i){
                    case 0 : intent = new Intent(getApplicationContext(), ListViewActivity.class);break;
                    case 1 : intent = new Intent(getApplicationContext(), ListViewSingleActivity.class);break;
                    case 2 : intent = new Intent(getApplicationContext(), ListViewMultiActivity.class);break;
                    case 3 : intent = new Intent(getApplicationContext(), CustomListViewActivity.class);break;
//                    case 4 : intent = new Intent(getApplicationContext(), ListViewActivity.class);break;
//                    case 5 : intent = new Intent(getApplicationContext(), ListViewActivity.class);break;
                    default: break;
                }
                if(intent!=null) startActivity(intent);

            }
        });





    }
}