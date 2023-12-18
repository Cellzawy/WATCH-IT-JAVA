package com.example.oopjavafx;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;

public class Admin extends User {

    public User getUser(String userID) {
        ArrayList<User> userList = new ArrayList<>();
        for (User user : userList) {
            if (user.getUser_ID().equals(userID)) {
                return user;
            }
        }
        return null;
    }
    public void addMovie(Movie movie) {
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(movie);
    }
    public void removeMovie(Movie movie) {
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.remove(movie);
    }
    public void resetRating(Movie movie) {
        for (Float rating : movie.Ratings) {
            rating = 0f;
        }
    }
    public void removeRating(Movie movie, User user) {
        HashMap ratings = user.getUserRatingsForMovie();
        if (ratings.containsKey(movie)) {
            ratings.remove(movie);
        }
    }
    public void suspendAccount(User user) {
        if (suspended) {
            System.out.println("User already suspended.");
        }
        else {
            user.suspended = true;
            System.out.println("User successfully suspended.");
        }
    }
    public void unsuspendAccount(User user) {
        if (suspended) {
            user.suspended = false;
            System.out.println("User already suspended.");
        }
        else {
            System.out.println("User already not suspended.");
        }
    }
    public String getMostRevMonth() {
        int max = 0;
        int index = 0;
        for (int i = 0; i < 12; i++) {
            if (Subscription.monthlyRevenue[i] > max) {
                max = Subscription.monthlyRevenue[i];
                index = i;
            }
        }
        return Month.of(index + 1).toString();
    }
    public String getMostSubbedPlan() {
        HashMap<String, Integer> plansCount = new HashMap<>();
        plansCount.put("Basic", Subscription.countBasic);
        plansCount.put("Standard", Subscription.countStandard);
        plansCount.put("Premium", Subscription.countPremium);

        HashMap.Entry<String, Integer> max = null;

        for (HashMap.Entry<String, Integer> entry : plansCount.entrySet()) {
            if (max == null || entry.getValue().compareTo(max.getValue()) > 0) {
                max = entry;
            }
        }

        return max.getKey();
    }

}