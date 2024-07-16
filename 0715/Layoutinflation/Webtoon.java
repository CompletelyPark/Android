package com.jica.layoutinflation;

import java.util.ArrayList;

public class Webtoon {
    private int img;
    private float grade;
    private String title, date;

    public Webtoon() {
    }

    public Webtoon(int img, float grade, String title, String date) {
        this.img = img;
        this.grade = grade;
        this.title = title;
        this.date = date;
    }

//  필요에 따라 method override

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Webtoon{" +
                "img=" + img +
                ", grade=" + grade +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
