package com.jica.sampletable111111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

/*
    ScrollView can only have one direct child
    then child in child can possible
 */

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    ImageView imageView;

//  by imageView show image object
//  (reference: image file load memory, when use image convert various drawable object

    BitmapDrawable bitmap;

    private boolean tf=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollView);
        imageView = findViewById(R.id.imageView);
        scrollView.setHorizontalScrollBarEnabled(true);


//      when res folder's resource access to java code, use Resources class
        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);
//      imageWidth
        int bitmapWidth = bitmap.getIntrinsicWidth();
//      imageHeight
        int bitmapHeight = bitmap.getIntrinsicHeight();


//      imageView set to image
        imageView.setImageDrawable(bitmap);

//      First imageView's height and weight setting is wrap_content.
//      imageView's layout Parameter change real imageWidth, imageHeight.
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
    }

    public void onButton1Clicked(View v) {
//      changeImage();
        if(tf) changeImage1();
        else changeImage2();

    }

    private void changeImage() {
        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image02);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();
        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
    }

    private void changeImage1() {
        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image02);
        tf=true;
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();
        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
        tf=false;
    }

    private void changeImage2() {
        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();
        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
        tf=true;
    }

}
