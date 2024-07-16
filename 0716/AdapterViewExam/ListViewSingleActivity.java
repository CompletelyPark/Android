package com.jica.adapterviewexam;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewSingleActivity extends AppCompatActivity {

    ArrayList<String> city;
    ListView listView;
    ArrayAdapter<String> adapter;

    Button btn_add, btn_del;
    EditText edit_text_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//      xml layout inflation - activity_list_view.xml file together use
        setContentView(R.layout.activity_list_view);

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
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_single_choice, city);
        listView.setAdapter(adapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

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
                int pos = listView.getCheckedItemPosition();
                if(pos!=ListView.INVALID_POSITION){
                    city.remove(pos);
                    listView.clearChoices();
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}