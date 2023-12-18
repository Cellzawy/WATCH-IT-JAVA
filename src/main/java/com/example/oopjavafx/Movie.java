package com.example.oopjavafx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.LocalDate;
import java.util.ArrayList;
public class Movie {

    //////////////////////////////////////////////////Fields////////////////////////////////////////////////////////////

    ArrayList<Float> Ratings = new ArrayList<Float>();
    private boolean Is_Watched= false; // status

    public int watchcount = 0;

    private final int movieID; // can be seen by Director

    private String movieTitle;

    private LocalDate releaseDate;

    private int RunningTime; // in minutes

    public String[] Genres; // Amgad 8iarha men private li public for search reasons

    //public Director director = new Director(); // Director object

    //private Cast cast[]; // Defining the array of cast

    String[] Languages;

    public double imdb_score; // over all rating wala THE Imbd score for the actual site?

    public String country;

    public double budget;

    public double revenue;

    public int user_Rating; // user rating for that movie

//    public Image poster = new Image("");

    public Movie() {
        user_Rating = 0;
        Is_Watched = false;
//        this.movieID = UUID.randomUUID().toString();
        this.movieID = 0;
        this.movieTitle = null;
        this.releaseDate = null;
        this.RunningTime = 0;
        Genres = null;
        Languages = null;
        imdb_score = 0;
        country = null;
        this.budget = 0;
        this.revenue = 0;
    }
    public Movie(int movieID) {
        this.movieID = movieID;
    }

    public Movie(boolean is_Watched, int movieID, String movieTitle, String releaseDate, int runningTime, double imdb_score, String country, double budget, double revenue) {
        Is_Watched = is_Watched;
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.releaseDate = LocalDate.parse(releaseDate);
        RunningTime = runningTime;
        this.imdb_score = imdb_score;
        this.country = country;
        this.budget = budget;
        this.revenue = revenue;
    }

    ///////////////////////////////////////////////Setters and Getters//////////////////////////////////////////////////

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;//.toLowerCase()
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = LocalDate.parse(releaseDate);
    }

    public void setRunningTime(int runningTime) {
        RunningTime = runningTime;
    }

    public void setGenres(String ...genres) {
        Genres = new String[genres.length];
        System.arraycopy(genres, 0, Genres, 0, genres.length);
    }

    public void setLanguages(String ...languages) {
        Languages = new String[languages.length];
        System.arraycopy(languages, 0, Languages, 0, languages.length);
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public int getMovieID() {
        return movieID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getRunningTime() {
        return RunningTime;
    }

    public void getGenres() {   /////alinist's method
        System.out.println("\nthis movie's genres are :");
        for(String Genre: Genres) {
            System.out.print(Genre + " ");
        }
    }


    public double getImdb_score() {
        imdb_score = 0;
        for(int i = 0 ; i < Ratings.size() ; i++) {
            imdb_score+= Ratings.get(i);
        }
        double result = imdb_score/Ratings.size();
        return Math.round(result * 10) / 10.0;
    }

    public String getCountry() {
        return country;
    }

    public double getBudget() {
        return budget;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setIs_Watched(boolean is_Watched) {
        Is_Watched = is_Watched;
    }

    public boolean getIs_Watched() {
        return Is_Watched;
    }



//    public void DisplayMovieDetails() {
//        System.out.println( this.movieTitle + " Details are : ");
//        System.out.println();
//    }

}