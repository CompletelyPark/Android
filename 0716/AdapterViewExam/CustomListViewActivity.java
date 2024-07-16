package com.jica.adapterviewexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class CustomListViewActivity extends AppCompatActivity {

//  original data
    ArrayList<Webtoon> data;

    ListView listView2;

//  adapter - custom adapter
    WebtoonAdapter webtoonAdapter;

//  user 가 만드는 custom adapter 는 반드시 baseAdapter를 상속 받아 만든다
    class WebtoonAdapter extends BaseAdapter
    {
//      original data
        ArrayList<Webtoon> data;

//      (to represent category view) xml layout file id
        int layoutid;

//      (to inflate layoutInflater object) categoty view
        Context context;
        LayoutInflater layoutInflater;

        public WebtoonAdapter(Context context, int layoutid, ArrayList<Webtoon> data){
            this.context = context;
            this.layoutid = layoutid;
            this.data = data;
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


//      original data count
        @Override
        public int getCount() {
            Log.d("Tag","WebtoonAdapter::getCount()"+data.size());
            return data.size();
        }

//      return ist original data
        @Override
        public Object getItem(int i) {
            Log.d("Tag","WebtoonAdapter::getitem(" + i + ")");

            return data.get(i);
        }

        @Override
//      return category view id
        public long getItemId(int i) {
            return 0;
        }

//      return ist category view
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
//          int i = 몇 번째 항복 뷰가 필요한 지 순번
//          View view = 항목 뷰가 전달, 최초 화면 구성시 에는 null 전달, 이 후부터 scroll 기능 동작할 때에는 재사용 할 항목 뷰를 전달 한다
//          View convertView
//          ViewGroup viewGroup = 리스트 뷰 자체, 부모 뷰
//          ViewGroup parent
            Log.d("Tag","WebtoonAdapter::getView(" + i + ")");

//          최초 화면 구성
            if(view == null) {
                Log.d("Tag","convertView is null");
                view = layoutInflater.inflate(layoutid,viewGroup,false);
            }

//          view 의 original data's content value 를 개별 위젯에 set
//          i 번째의 원본 data
            Webtoon webtoon = data.get(i);
            ImageView imageViewWeb = view.findViewById(R.id.imageViewWeb);
            imageViewWeb.setImageResource(webtoon.getImg());

            TextView text_title = view.findViewById(R.id.text_title);
            TextView text_grade = view.findViewById(R.id.text_grade);
            TextView text_date = view.findViewById(R.id.text_date);

            text_title.setText(webtoon.getTitle());
            text_grade.setText(webtoon.getGrade()+"");
            text_date.setText(webtoon.getDate());


//          항목 view return
            return view;

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      xml layout inflation
        setContentView(R.layout.activity_custom_list_view);

//      Get ui object reference value
        listView2 = findViewById(R.id.listView2);

//      make original data
        makeData();

//      make adapter
        webtoonAdapter = new WebtoonAdapter(getApplicationContext(),R.layout.webtoon,data);

//      link listView and adapter
        listView2.setAdapter(webtoonAdapter);

//      항목 뷰를 클릭 했을 때의 이벤트 핸들러 호출
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//          i = position
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String msg = i + "번째 항목" + data.get(i);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

//              만화 내용을 본다면 이 곳에서 Activity 를 호출 한다
            }
        });
    }

    public void makeData() {
        if (data != null) {
            data.clear();
            data = null;
        }

        data = new ArrayList<Webtoon>();
        Webtoon webtoon1;
        webtoon1 = new Webtoon(R.drawable.thumbnail_web1, 9.99f, "제목 1", "2024-07.15");
        data.add(webtoon1);
        webtoon1 = new Webtoon(R.drawable.thumbnail_web2, 9.98f, "제목 2", "2024-07.14");
        data.add(webtoon1);
        webtoon1 = new Webtoon(R.drawable.thumbnail_web3, 9.97f, "제목 3", "2024-07.13");
        data.add(webtoon1);
        webtoon1 = new Webtoon(R.drawable.thumbnail_web4, 9.96f, "제목 4", "2024-07.12");
        data.add(webtoon1);
        webtoon1 = new Webtoon(R.drawable.thumbnail_web5, 9.95f, "제목 5", "2024-07.11");
        data.add(webtoon1);
        webtoon1 = new Webtoon(R.drawable.thumbnail_web6, 9.94f, "제목 6", "2024-07.10");
        data.add(webtoon1);
        webtoon1 = new Webtoon(R.drawable.thumbnail_web7, 9.93f, "제목 7", "2024-07.09");
        data.add(webtoon1);
        webtoon1 = new Webtoon(R.drawable.thumbnail_web8, 9.92f, "제목 8", "2024-07.08");
        data.add(webtoon1);
        webtoon1 = new Webtoon(R.drawable.thumbnail_web9, 9.91f, "제목 9", "2024-07.07");
        data.add(webtoon1);
        webtoon1 = new Webtoon(R.drawable.thumbnail_web10, 9.90f, "제목 10", "2024-07.06");
        data.add(webtoon1);
        webtoon1 = new Webtoon(R.drawable.thumbnail_web1, 9.89f, "제목 11", "2024-07.05");
        data.add(webtoon1);
        webtoon1 = new Webtoon(R.drawable.thumbnail_web2, 9.88f, "제목 12", "2024-07.04");
        data.add(webtoon1);
        webtoon1 = new Webtoon(R.drawable.thumbnail_web3, 9.87f, "제목 13", "2024-07.03");
        data.add(webtoon1);
        webtoon1 = new Webtoon(R.drawable.thumbnail_web4, 9.86f, "제목 14", "2024-07.02");
        data.add(webtoon1);
        webtoon1 = new Webtoon(R.drawable.thumbnail_web5, 9.85f, "제목 15", "2024-07.01");
        data.add(webtoon1);
        webtoon1 = new Webtoon(R.drawable.thumbnail_web6, 9.84f, "제목 16", "2024-06.30");
        data.add(webtoon1);

    }

}