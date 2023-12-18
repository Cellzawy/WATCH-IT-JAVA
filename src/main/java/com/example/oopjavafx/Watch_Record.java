package com.example.oopjavafx;

public class Watch_Record{

    private final int userId;
    private Movie movie;
    private Integer rating; //Integer provide null value as default which is needed for no rating case
    private int day;
    private int month;
    private int year;

    public Watch_Record(int userId) {
        this.userId = userId;
    }
    public Watch_Record(int userId,Movie movie,int rating,int day,int month,int year) {
        this.userId = userId;
        this.movie = movie;
        this.rating = rating;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getUserId() {
        return userId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        if(rating ==null||rating>=0 &&rating<5) {
            this.rating = rating;
        }
    }




    public void getDate() {
        System.out.println(day+"/"+month+ "/"+year);
    }
    public void setDate(int d,int m,int y) {
        day=d;
        month=m;
        year=y;
    }

}