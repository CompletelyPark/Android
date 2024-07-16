package com.jica.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ActivityLifeCycle extends AppCompatActivity {



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
//  onResume method execute, then screen context show
//  activate state
//  then user interaction

//  if clicked exit button or call other activity
//  then current activity deactivated
//  after onPause method call

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Tag","MainActivity:: onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Tag","MainActivity:: onStop()");

    }

/*
    onPause, onStop 상태에서는 app 이 강제로 종료 될 수 있는 killable 상태가 된다
    (android system 에서 강제 종료 됐거나, 화면 회전) -- activity가 종료된지 모르는 상태에서 내가 다시 시작하고 싶다면 onCreate 부터 다시 시작해야한다


*/


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Tag","MainActivity:: onDestroy()");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Tag","MainActivity:: onCreate(Bundle)");
//      Log.v(), Log.i(), Log.d(), Log.w(), Log.e()
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Tag","MainActivity:: onRestart()");

    }


}