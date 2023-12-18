package com.example.oopjavafx;

import java.util.ArrayList;
/**
 * The `Director` class represents a person who is a director in the film industry. It extends the `Person` class and adds
 * additional properties such as a list of movies directed, a list of awards received, and the number of awards and directed movies.
 */
public class Director extends Person {
    /**
     * The movies directed by the director.
     */
    public ArrayList < String > movies;
    /**
     * The awards won by the director.
     */
    public ArrayList < String > awards;
    /**
     * The number of movies directed by director.
     */
    public int number_of_directed_movies;
    /**
     * The number of awards won by the director.
     */
    public int number_of_awards;
    /**
     * Constructs a new instance of the `Director` class with the specified parameters.
     *
     * @param first_name             the first name of the director
     * @param last_name              the last name of the director
     * @param nationality            the nationality of the director
     * @param gender                 the gender of the director
     * @param age                    the age of the director
     * @param movies                 the list of movies directed by the director
     * @param awards                 the list of awards received by the director
     */
    public Director(String first_name, String last_name, String nationality, String gender, int age,ArrayList < String > movies,
                    ArrayList < String > awards) {
        super(first_name, last_name, nationality, gender, age);
        this.movies = movies;
        this.awards = awards;
    }

    public int getNumber_of_awards() {
        return awards.size();
    }
    public int getNumber_of_directed_movies() {
        return movies.size();
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