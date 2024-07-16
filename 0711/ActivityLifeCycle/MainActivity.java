package com.jica.activitylifecycle;


import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private LinearLayout layout1;
    private LinearLayout layout2;
    private FrameLayout frameLayout;

    private int index = 0;
    private boolean tf = true;

    private Button btnToast;

    private ProgressBar progressBar;

    private TextView txt_progressValue;

    private int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      매개 변수로 전달된 Bundle savedInstanceState 가 null 이면 복구할 정보 x
//      null 이 아니면 복구할 정보 o -> 갑 추출 해서 복구

        setContentView(R.layout.activity_main);

        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        frameLayout = findViewById(R.id.frameLayout);

        btnToast = findViewById(R.id.btnToast);
        btnToast.setOnClickListener(view -> Toast.makeText(getApplicationContext(), "Toast message",Toast.LENGTH_LONG).show());

        progressBar = findViewById(R.id.progressBar);
        Log.d("Tag","progressbar current value" + progressBar.getProgress());
        progressBar.setProgress(50);
        Log.d("Tag","progressbar current value" + progressBar.getProgress());


        txt_progressValue = findViewById(R.id.txt_progressValue);


    }

    public void onButtonClicked5(View view) {
        score-=5;
        progressBar.setProgress(score);
        txt_progressValue.setText(score+"");
    }

    public void onButtonClicked6(View view) {
        score+=5;
        progressBar.setProgress(score);
        txt_progressValue.setText(score+"");


    }

    public void onButtonClicked1(View v){
        viewFrame();
    }

    public void viewFrame(){
        if(tf) {
            frameLayout.setVisibility(View.VISIBLE);
            tf = false;
        }
        else {
            frameLayout.setVisibility(View.INVISIBLE);
            tf = true;
        }
    }


    public void onButtonClicked(View v){
        changeImage();
    }

    private void changeImage(){
        if(index==0){
            layout1.setVisibility(View.VISIBLE);
            layout2.setVisibility(View.INVISIBLE);

            index=1;
        }

        else if(index==1){
            layout1.setVisibility(View.INVISIBLE);
            layout2.setVisibility(View.VISIBLE);

            index=0;
        }
    }

    public void onButtonClicked3(View v){
        Intent intent = new Intent(getApplicationContext(),SubActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Tag","MainActivity:: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Tag","MainActivity:: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Tag","MainActivity:: onPause()");
        saveState();

    }

    private void saveState() {

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Tag","MainActivity:: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Tag","MainActivity:: onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Tag","MainActivity:: onRestart()");
    }

//  when current activity deactivated, after onStop method activate
//  매개변수로 전달된 bundle object 에 필요한 임시정보 저장하라는 의미 
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Tag","MainActivity:: onSaveInstance()");
//      매개변수 Bundle OutState 에 필요한 임시 정보 저장
//      해당 bundle object 는 android system 이
//      activity 를 필요할 때 새로 생성할 때 onCreate method를 새로 생성하고
//
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Tag","MainActivity:: onRestoreInstance()");

    }
}