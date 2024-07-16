package com.jica.activitycall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MovieInformationActivity extends AppCompatActivity {

    TextView text_title,idDirector,idActor,idStory;

    ImageView imageView;

    RatingBar ratingBar;
    TextView ratingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_information);


//      get R.id value
        text_title = findViewById(R.id.text_title);
        idDirector = findViewById(R.id.idDirector);
        idActor = findViewById(R.id.idActor);
        idStory = findViewById(R.id.idStory);

        imageView = findViewById(R.id.imageView);

//      current activity call and get intent object delivered

        Intent intent = getIntent();

//      Get additional information delivered intent object

//      String title = intent.getStringExtra("title");
//      int poster = intent.getIntExtra("poster",0);
//      String director = intent.getStringExtra("director");
//      String actor = intent.getStringExtra("actor");
//      String story = intent.getStringExtra("story");

//      activate ui object to additional information
//      idvalue.setText(title);
//        text_title.setText(title);
//        imageView.setImageResource(poster);
//        idDirector.setText(director);
//        idActor.setText(actor);
//        idStory.setText(story);

//      Get Ui Object
        MovieInfo movieInfo = (MovieInfo) intent.getSerializableExtra("movieinfo");
        text_title.setText(movieInfo.title);
        imageView.setImageResource(movieInfo.posterId);
        idDirector.setText(movieInfo.director);
        idActor.setText(movieInfo.actors);
        idStory.setText(movieInfo.story);

        ratingBar = findViewById(R.id.ratingBar);
        ratingText = findViewById(R.id.ratingText);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String str = rating+"";
                Toast.makeText(getApplicationContext(), str,Toast.LENGTH_LONG).show();
                ratingText.setText(str);
            }
        });
    }
}