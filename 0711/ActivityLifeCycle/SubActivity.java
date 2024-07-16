package com.jica.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        Log.w("Tag","SubActivity:: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("Tag","SubActivity:: onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("Tag","SubActivity:: onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("Tag","SubActivity:: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("Tag","SubActivity:: onDestroy()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    public void onButtonClicked4(View view) {
//      current activity terminate
        finish();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w("Tag","SubActivity:: onRestart()");
    }

}