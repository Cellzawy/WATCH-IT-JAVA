import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Movie {

    /**
     * The movie identifier which is unique for every movie even if there are movie titles that are the same
     */
    //////////////////////////////////////////////////Fields////////////////////////////////////////////////////////////
    private final int movieID;

    /**
     * Movie title is for the name of the movie
     */
    private String movieTitle;

    /**
     * It is the release date of the movie in the format of "dd-MM-yyyy"
     */
    private LocalDate releaseDate;

    /**
     * The length of the movie in minutes
     */
    private int RunningTime; // in minutes

    /**
     * The genres in which this movie belongs to
     */
    public String[] Genres; // Amgad 8iarha men private li public for search reasons

    /**
     * the director object that extends Person class and he is the director of that movie
     */
    public Director director; // Director object

    /**
     * The languages the is spoken with
     */
    String[] Languages;

    /**
     * It's the indicator of how well the movie is from a scale of 1 to 5 which the users give this rating to the movie
     */
    public double imdb_score; // over all rating wala THE Imbd score for the actual site?

    /**
     * the country in which this movie is made in
     */
    public String country;

    /**
     * the amount of money spent in the production of this movie
     */
    public double budget;

    /**
     * the amount of income money gained by the movie company/producers after the movie is released
     */
    public double revenue;

    private ArrayList<Actor> Cast;
    /**
     * the set of ratings all users have given to that movie and they are used to get the imdb score aka the average rating of the movie
     */
    ArrayList<Float> Ratings = new ArrayList<Float>();
    /**
     * the number of people who watched that movie and add them to their watched list
     */
    public int watchCount = 0;

    /**
     * <p></p>
     */
    public Movie() {
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
        director = new Director();
        Cast = new ArrayList<>();
    }
    public Movie(int movieID) {
        this.movieID = movieID;
        director = new Director();
        Cast = new ArrayList<>();
    }

    /**
     * This parametrized constructor constructs the movie with the following fields :
     *
     * @param movieID
     * @param movieTitle
     * @param releaseDate
     * @param runningTime
     * @param genres
     * @param director
     * @param languages
     * @param imdb_score
     * @param country
     * @param budget
     * @param revenue
     * @param cast
     * @param ratings
     * @param watchCount
     */
    public Movie(int movieID, String movieTitle, LocalDate releaseDate, int runningTime, String[] genres, Director director, String[] languages, double imdb_score, String country, double budget, double revenue, ArrayList<Actor> cast, ArrayList<Float> ratings, int watchCount) {
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.releaseDate = releaseDate;
        RunningTime = runningTime;
        Genres = genres;
        this.director = director;
        Languages = languages;
        this.imdb_score = imdb_score;
        this.country = country;
        this.budget = budget;
        this.revenue = revenue;
        Cast = cast;
        Ratings = ratings;
        this.watchCount = watchCount;
    }

    ///////////////////////////////////////////////Setters and Getters//////////////////////////////////////////////////

    /**
     * <p>Sets the movie title for the movie</p>
     * @param movieTitle the movie title that we set for the movie
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /**
     * <p>Sets the movie release date for the movie</p>
     * @param releaseDate the release date of the movie
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
    }

    /**
     * <p>Sets the movie length/running time for the movie</p>
     * @param runningTime the length of the movie in minutes
     */
    public void setRunningTime(int runningTime) {
        RunningTime = runningTime;
    }

    /**
     * <p>Sets a list of genres to the movie</p>
     * @param genres the genre(s) to be added to the movie
     */
    public void setGenres(String ...genres) {
        Genres = new String[genres.length];
        System.arraycopy(genres, 0, Genres, 0, genres.length);
    }

    /**
     * <p>Sets a list of languages spoken to the movie</p>
     * @param languages the language(s) spoken to be added to the movie
     */
    public void setLanguages(String ...languages) {
        Languages = new String[languages.length];
        System.arraycopy(languages, 0, Languages, 0, languages.length);
    }

    /**
     * <p>Sets the country where the movie was created to the movie</p>
     * @param country the origin/country in which the movie was created
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * <p>Sets the budget for the movie</p>
     * @param budget the amount of money spent in the making of the movie
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }

    /**
     * <p>Sets the amount of money gained for the movie</p>
     * @param revenue the amount of money gained by the movie
     */
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    /**
     * <p>This method returns the movie identifier for this movie</p>
     * @return the movie identifier
     */
    public int getMovieID() {
        return movieID;
    }

    /**
     * <p>This method returns the movie title of the movie</p>
     * @return the movie title
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * <p>This method returns the movie release date of the movie</p>
     * @return the release date of the movie
     */
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * <p>This method returns the movie length of the movie</p>
     * @return the running time/length of the movie
     */
    public int getRunningTime() {
        return RunningTime;
    }

    /**
     * <p>This method displays the genres of the movie</p>
     */
    public void getGenres() {   /////alinist's method
        System.out.println("\nthis movie's genres are :");
        for(String Genre: Genres) {
            System.out.print(Genre + " ");
        }
    }


    /**
     * <p>This method returns the imdb score by calculating the average rating of the users to the movie</p>
     * @return the imdb score/average score of the movie
     */
    public double getImdb_score() {
        imdb_score = 0;
        for(int i = 0 ; i < Ratings.size() ; i++) {
            imdb_score+= Ratings.get(i);
        }
        double result = imdb_score/Ratings.size();
        return Math.round(result * 5) / 5.0;
    }

    /**
     * <p>this method returns the country of origin for this movie</p>
     * @return the origin/country in which the movie was created in
     */
    public String getCountry() {
        return country;
    }

    /**
     * <p>This method returns the amount of money spent in the production of the movie</p>
     * @return the budget/amount of money spent on the movie
     */
    public double getBudget() {
        return budget;
    }

    /**
     * <p>This method returns the amount of money gained from the movie</p>
     * @return the amount of money gained from this movie
     */
    public double getRevenue() {
        return revenue;
    }

    /**
     * <p>this method returns a list of actors who acted in the movie</p>
     * @return the actor(s) who contributed in this movie
     */
    public ArrayList<Actor> getCast() {
        return Cast;
    }

    /**
     * <p>Sets a list of actors who contributed in the making of the movie</p>
     * @param cast the actor(s) who acted in the movie
     */
    public void setCast(ArrayList<Actor> cast) {
        Cast = cast;
    }

}