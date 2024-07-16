package com.jica.activitycall;


import java.io.Serializable;

//  1건의 영화 정보 표현 class
public class MovieInfo implements Serializable {
    String title;

//  res/drawable/image.png id
    int posterId;
    String director;
    String actors;
    String story;

    public MovieInfo() {
    }

    public MovieInfo(String title, int posterId, String director, String actors,  String story) {
        this.title = title;
        this.posterId = posterId;
        this.director = director;

        this.actors = actors;

        this.story = story;
    }

//  if you need, declare getter, setter, hashcode, equals, tos
// String method


    @Override
    public String toString() {
        return "MovieInfo{" +
                "title='" + title + '\'' +
                ", posterId=" + posterId +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                ", story='" + story + '\'' +
                '}';
    }
}
