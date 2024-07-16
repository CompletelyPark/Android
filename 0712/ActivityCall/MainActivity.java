package com.jica.activitycall;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_MOVIE_ACTIVITY = 100;

    private RadioGroup radioGroup;
    private RadioButton btn1,btn2,btn3,btn4,btn5,btn6;
    private Button btnDetail;

    String titles[] = {"탈출","탈주","하이재킹","인사이드 아웃2", "콰이어트 플레이스", "플라이 미 투 더 문"};
    int posterId[] = {R.drawable.escape2,R.drawable.escape1,R.drawable.hijaking,R.drawable.insideout2,
                        R.drawable.quiteplace2,R.drawable.flymetothemoon};

    String directors[] = {"김태곤","이종필","김성현","켈시 맨","마이클 사노스키","그렉 버랜티"};
    String actors[] = {"이선균, 주지훈, 김희원", "이제훈, 구교환, 홍사빈","하정우, 여진구, 성동일","에이미 포엘러, 마야 호크, 루이스 블랙",
            "루피타 뇽, 조셉 퀸, 디몬 하운수", "스칼릿 조한슨, 채닝 테이텀"};
    String stories[] = {
            "붕괴 위기의 공항대교, 생존자 전원이 타겟이 되었다. " +
                    "기상 악화로 한치 앞도 구분할 수 없는 공항대교. 연쇄 추돌 사고와 폭발로 붕괴 위기에 놓인 다리 위에 사람들이 고립...",
            "“내 앞 길 내가 정했습니다” 휴전선 인근 북한 최전방 군부대. " +
                    "10년 만기 제대를 앞둔 중사 ‘규남’(이제훈)은 미래를 선택할 수 없는 북을 벗어나 원하는 것을 ... ",
            "1971년 겨울 속초공항 여객기 조종사 태인(하정우)과 규식(성동일)은 김포행 비행에 나선다. " +
                    "승무원 옥순(채수빈)의 안내에 따라 탑승 중인 승객들의 분주함... ",
            "디즈니·픽사의 대표작 <인사이드 아웃> 새로운 감정과 함께 돌아오다! " +
                    "13살이 된 라일리의 행복을 위해 매일 바쁘게 머릿속 감정 컨트롤 본부를 운영하는 ‘기...",
            "쉿, 살고 싶다면 절대 소리내지 말 것! 평균 소음 90 데시벨을 자랑하는 미국 최대도시 뉴욕, " +
                    "고양이 ‘프로도’와 함께 간만에 외출을 나온 ‘사미라’는 공연을 보..",
            "1960년대 우주 경쟁 시대, 거듭된 실패로 멀어진 대중들의 관심을 다시 모으기 위해 NASA는 " +
                    "아폴로 11호 발사를 앞두고 마케팅 전문가를 고용한다. 수단과 방법을 가리지 ... "
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      get Ui object reference value
        radioGroup = findViewById(R.id.radioGroup);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);

        btnDetail = findViewById(R.id.btnDetail);

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              current clicked information 판별
                int curid = radioGroup.getCheckedRadioButtonId();

//              call Activity
                Intent intent = new Intent(getApplicationContext(), MovieInformationActivity.class);

//              delivered to call activity
//                if(curid==R.id.btn1){
////              using intent object's additional information, set delivered information
//                    intent.putExtra("title","탈출");
//                    intent.putExtra("poster",R.drawable.escape1);
//                    intent.putExtra("director","김태곤");
//                    intent.putExtra("actor","이선균, 주지훈, 김희원");
//                    intent.putExtra("story","붕괴 위기의 공항대교, 생존자 전원이 타겟이 되었다. " +
//                            "기상 악화로 한치 앞도 구분할 수 없는 공항대교. 연쇄 추돌 사고와 폭발로 붕괴 위기에 놓인 다리 위에 사람들이 고립...");
//
//                }
//
//                else if(curid==R.id.btn2){
//                    intent.putExtra("title","탈주");
//                    intent.putExtra("poster",R.drawable.escape2);
//                    intent.putExtra("director","이종필");
//                    intent.putExtra("actor","이제훈, 구교환, 홍사빈");
//                    intent.putExtra("story","“내 앞 길 내가 정했습니다” 휴전선 인근 북한 최전방 군부대. " +
//                            "10년 만기 제대를 앞둔 중사 ‘규남’(이제훈)은 미래를 선택할 수 없는 북을 벗어나 원하는 것을 ... ");
//                }
//
//                else if(curid==R.id.btn3){
//                    intent.putExtra("title","하이재킹");
//                    intent.putExtra("poster",R.drawable.hijaking);
//                    intent.putExtra("director","김성한");
//                    intent.putExtra("actor","하정우, 여진구, 성동일");
//                    intent.putExtra("story","1971년 겨울 속초공항 여객기 조종사 태인(하정우)과 규식(성동일)은 김포행 비행에 나선다. " +
//                            "승무원 옥순(채수빈)의 안내에 따라 탑승 중인 승객들의 분주함... ");
//                }
//
//                else if(curid==R.id.btn4){
//                    intent.putExtra("title","인사이드 아웃2");
//                    intent.putExtra("poster",R.drawable.insideout2);
//                    intent.putExtra("director","켈시 맨");
//                    intent.putExtra("actor","에이미 포엘러, 마야 호크, 루이스 블랙");
//                    intent.putExtra("story","디즈니·픽사의 대표작 <인사이드 아웃> 새로운 감정과 함께 돌아오다! " +
//                            "13살이 된 라일리의 행복을 위해 매일 바쁘게 머릿속 감정 컨트롤 본부를 운영하는 ‘기...");
//                }
//
//                else if(curid==R.id.btn5){
//                    intent.putExtra("title","콰이어트 플레이스 ");
//                    intent.putExtra("poster",R.drawable.quiteplace2);
//                    intent.putExtra("director","마이클 사노스키");
//                    intent.putExtra("actor","루피타 뇽, 조셉 퀸, 디몬 하운수");
//                    intent.putExtra("story","쉿, 살고 싶다면 절대 소리내지 말 것! 평균 소음 90 데시벨을 자랑하는 미국 최대도시 뉴욕, " +
//                            "고양이 ‘프로도’와 함께 간만에 외출을 나온 ‘사미라’는 공연을 보..");
//                }
//
//                else if(curid==R.id.btn6){
//                    intent.putExtra("title","플라이 미 투 더 문");
//                    intent.putExtra("poster",R.drawable.flymetothemoon);
//                    intent.putExtra("director","그랙 버랜티");
//                    intent.putExtra("actor","스칼릿 조한슨, 채닝 테이텀");
//                    intent.putExtra("story","1960년대 우주 경쟁 시대, 거듭된 실패로 멀어진 대중들의 관심을 다시 모으기 위해 NASA는 " +
//                            "아폴로 11호 발사를 앞두고 마케팅 전문가를 고용한다. 수단과 방법을 가리지 ... ");
//                }

                int index = -1;
                if (curid == R.id.btn1) index = 0;
                else if (curid == R.id.btn2) index = 1;
                else if (curid == R.id.btn3) index = 2;
                else if (curid == R.id.btn4) index = 3;
                else if (curid == R.id.btn5) index = 4;
                else if (curid == R.id.btn6) index = 5;


//                if(index != -1) {
//                    intent.putExtra("title", titles[index]);
//                    intent.putExtra("poster", posterId[index]);
//                    intent.putExtra("director", directors[index]);
//                    intent.putExtra("actor", actors[index]);
//                    intent.putExtra("story", stories[index]);
//                }

                MovieInfo movieInfo = new MovieInfo(titles[index],posterId[index],directors[index],actors[index],stories[index]);
                if (index !=-1) intent.putExtra("movieinfo", movieInfo);



//                startActivity(intent);

//              Specific Activity activate and activity deactivate if u want to receive result using down method
//              and to receive result override onActivityResult method
                startActivityForResult(intent,REQUEST_MOVIE_ACTIVITY);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        Log.d("Tag","requestcode " + requestCode);
        Log.d("Tag","resultcode " + resultCode);
        Log.d("Tag","intent " + data);

    }
}