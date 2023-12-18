package com.example.oopjavafx;

import java.util.ArrayList;
/**
 * The `Actor` class represents a person who is an actor in the film industry. It extends the `Person` class and adds
 * additional properties such as a list of movies acted in, a list of awards received, and the number of awards.
 */
public class Actor extends Person{
    /**
     * The movies contributed by the actor.
     */
    public ArrayList < String > movies;
    /**
     * The awards won by the actor.
     */
    public ArrayList < String > awards;
    /**
     * The number of awards won by the actor.
     */
    public int number_of_awards;
    /**
     * Constructs a new instance of the `Actor` class with the specified parameters.
     *
     * @param first_name             the first name of the actor
     * @param last_name              the last name of the actor
     * @param nationality            the nationality of the actor
     * @param gender                 the gender of the actor
     * @param age                    the age of the actor
     * @param movies                 the list of movies acted in by the actor
     * @param awards                 the list of awards received by the actor
     */
    public Actor(String first_name, String last_name, String nationality, String gender, int age,ArrayList < String > movies,
                 ArrayList < String > awards) {
        super(first_name, last_name, nationality,gender, age);
        this.movies = movies;
        this.awards = awards;
    }
    public void setNumber_of_awards(int number_of_awards) {
        this.number_of_awards = number_of_awards;
    }
    public int getNumber_of_awards() {
        return number_of_awards;
    }
    public void addMovie(String movies) {
        this.movies.add(movies);
    }
    public ArrayList < String > getMovies() {
        return this.movies;
    }
    public void addAwards(String awards) {
        this.awards.add(awards);
    }
    public ArrayList < String > getAwards() {
        return this.awards;
    }
}