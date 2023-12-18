package com.example.oopjavafx;

import java.util.*;


public class User {
    ////////////////////////////////////Fields/////////////////////////////////////////////////////////
    private final String User_ID;
    protected boolean suspended = false;
    protected boolean loggedIn = false;
    private HashMap MoviesStatues = new HashMap();
    private HashMap MoviesRatings = new HashMap();
    private static ArrayList<Movie> MovieList = new ArrayList<Movie>();
    private ArrayList<Movie> Watched = new ArrayList<Movie>();
    private ArrayList<Movie> Later = new ArrayList<Movie>();
    public Subscription subscription = new Subscription();
    private String first_name;
    private String last_name;
    private String user_email;
    private String user_password;
    private String theme_preference;


    /********************** Constructor**********************/

    public User() {
        this.User_ID = UUID.randomUUID().toString();// generate unique id for each user
        subscription.setPriceOfPlan(0);
    }

    /********************** Methods**********************/

    public String getUser_ID() {
        return User_ID;
    }
    public HashMap getUserRatingsForMovie() {
        return MoviesRatings;
    }
    public boolean getSuspendedValue() {
        return suspended;
    }


    /////////////////Custom Methods


    /////////////////Certain User
    public void SetUserRatingForMovie(Movie movie,int rating) { //the movie must be on the watched list first (rating is not from the user but from the site)
        if (MoviesStatues.get(movie) == null || (boolean) MoviesStatues.get(movie)) {
            for (int i = 0; i < Watched.size(); i++) {
                if (movie.getMovieTitle().equalsIgnoreCase(Watched.get(i).getMovieTitle())) {
                    if (rating <= 10 && rating >= 0){
                        MoviesRatings.put(movie,rating);
                        Watched.get(i).Ratings.add((float)rating);
                    }
                    else {
                        MoviesRatings.put(movie,0);
                        Watched.get(i).Ratings.add(0f);
                    }
                }
            }

        } else {
            System.out.println("Movie wasn't watched");
        }
    }

    public void displayUserRatingsForMovie() {
        System.out.println("Watched Movie List : ");
        if(Watched.isEmpty()) {
            System.out.println("No Movies Available");
        } else {
            for (int i = 0; i < Watched.size(); i++) {
                System.out.println(i + 1 + ") " + Watched.get(i).getMovieTitle() + " " + MoviesRatings.get(Watched.get(i)));
            }
        }
    }

    public void GetMovieStatusForUser(Movie movie){
        String movie_status;
        if ((boolean)MoviesStatues.get(movie)){ // m4 3arfen 2zai by4t8l bs 3la allah XDD
            movie_status = "Watched";
        }
        else{
            movie_status = "Not Watched";
        }
        for (int i = 0; i < MovieList.size(); i++) {
            if (MovieList.get(i).getMovieTitle().toLowerCase().equals(movie.getMovieTitle().toLowerCase())){
                System.out.println(MovieList.get(i).getMovieTitle()+"  "+movie_status);
            }
        }
    }

    /********************** START OF needed to be tested *************************/
/////////////////All User
    public static void GetRecentMovies(int max_recent_movies_want_to_appear) { // ne5tar limit li 3adad el haiezharo fi el recent
        int index = 1;
        for (int i = MovieList.size()-1; i >= 0; i--) {
            if (i>((MovieList.size()-1)-max_recent_movies_want_to_appear)){
                System.out.println(index++ + ") " +MovieList.get(i).getMovieTitle());
            }
        }
    }

    public static void GetTopRatedMovies(){
        ArrayList <Movie> sortedMoviesRating  = new ArrayList<Movie>();
        for (int i = 0; i < MovieList.size(); i++) {
            sortedMoviesRating.add(MovieList.get(i));
        }
        Collections.sort(sortedMoviesRating, new Comparator<Movie>() {

            public int compare(Movie o1, Movie o2) {
                if (o1.imdb_score<o2.imdb_score) {
                    return 1;
                }
                else if (o1.imdb_score>o2.imdb_score) {
                    return -1;

                }
                else
                {
                    return 0;
                }
            }
        });

        for (int i = 0; i < sortedMoviesRating.size(); i++) {
            System.out.println((i+1)+") "+sortedMoviesRating.get(i).getMovieTitle() + " " + sortedMoviesRating.get(i).getImdb_score());
        }

    }

    public static void GetTopWatchedMovies(){
        ArrayList <Movie> sortedMoviesRating  = new ArrayList<Movie>();
        for (int i = 0; i < MovieList.size(); i++) {
            sortedMoviesRating.add(MovieList.get(i));
        }
        Collections.sort(sortedMoviesRating, new Comparator<Movie>() {

            public int compare(Movie o1, Movie o2) {
                if (o1.watchcount<o2.watchcount) {
                    return 1;
                }
                else if (o1.watchcount>o2.watchcount) {
                    return -1;

                }
                else
                {
                    return 0;
                }
            }
        });

        for (int i = 0; i < sortedMoviesRating.size(); i++) {
            System.out.println((i+1)+") "+sortedMoviesRating.get(i).getMovieTitle() + " " + sortedMoviesRating.get(i).watchcount);
        }

    }



    /////////////////MovieList

    public static void addMovieToMovieList(Movie movie) {

        boolean Is_Added_Before_InMovieList = false;
        for (int i = 0; i < MovieList.size(); i++) {
            if (MovieList.get(i).getMovieTitle().toLowerCase().equals(movie.getMovieTitle().toLowerCase())){
                Is_Added_Before_InMovieList = true;
                break;
            }
        }
        if (!Is_Added_Before_InMovieList){
            MovieList.add(movie);
        }
    }

    public static void removeMovieFromMovieList(Movie movie) {
        MovieList.remove(movie);
    }

    public static void getMovieList() {
        System.out.println("Movie List : ");
        if(MovieList.isEmpty()) {
            System.out.println("No Movies Available");
        } else {
            for (int i = 0; i < MovieList.size(); i++) {
                System.out.println(i + 1 + ") " + MovieList.get(i).getMovieTitle());
            }
        }
    }

    /// <summary>
    /// search on Movie list only because it's static method.The parameter "genre_of_Movie" is an input from the site not the client
    /// </summary>
    /// <param name="genre_of_Movie">what genre the client want to look for.</param>
    public static void SearchMovieByGenre(String genre_of_Movie) { //search on the movie list
        int index = 1;
        for (int i = 0; i < MovieList.size(); i++) {
            for (int j = 0; j < MovieList.get(i).Genres.length; j++) {
                if (MovieList.get(i).Genres[j].toLowerCase().equals(genre_of_Movie.toLowerCase())) {
                    System.out.println(index++ + ") " + MovieList.get(i).getMovieTitle());
                }
            }
        }
    }

    public static void SearchMovieByName(String name_of_Movie){
        int index = 1;
        for (int i = 0; i <MovieList.size(); i++) {
            if (MovieList.get(i).getMovieTitle().toLowerCase().contains(name_of_Movie.toLowerCase())){
                System.out.println(index++ + ") " + MovieList.get(i).getMovieTitle());
            }
        }
    }



/////////////////Watched and Later list

    /// <summary>
    /// search on the watched and later list and the parameters "Wanted_List"and "genre_of_Movie" are inputs from the site not the client
    /// </summary>
    /// <param name="Wanted_List">what list the client want to search on.</param>
    /// <param name="genre_of_Movie">what genre the client want to look for.</param>
    /// <param name="name_of_Movie">what movie title the client want to look for.</param>
    public void SearchMovieByGenre(String Wanted_List,String genre_of_Movie) {
        ArrayList<Movie> List = new ArrayList<Movie>();
        switch (Wanted_List.toLowerCase()){
            case "watched":
                List = Watched;
                break;
            case "later":
                List = Later;
                break;
        }
        int index = 1;
        for (int i = 0; i < List.size(); i++) {
            for (int j = 0; j < List.get(i).Genres.length; j++) {
                if (List.get(i).Genres[j].toLowerCase().equals(genre_of_Movie.toLowerCase())) {
                    System.out.println(index++ + ") " + List.get(i).getMovieTitle());
                }
            }
        }
    }

    public void SearchMovieByName(String Wanted_List,String name_of_Movie) {
        ArrayList<Movie> List = new ArrayList<Movie>();
        switch (Wanted_List.toLowerCase()){
            case "watched":
                List = Watched;
                break;
            case "later":
                List = Later;
                break;
        }
        int index = 1;
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getMovieTitle().toLowerCase().contains(name_of_Movie.toLowerCase())) {
                System.out.println(index++ + ") " + List.get(i).getMovieTitle());
            }
        }
    }


    /////////////////Watched list

    public void addMovieToWatched(Movie movie) {
        boolean Is_Added_Before_InWatched = false;
        for (int i = 0; i < Watched.size(); i++) {
            if (Watched.get(i).getMovieTitle().toLowerCase().equals(movie.getMovieTitle().toLowerCase())){
                Is_Added_Before_InWatched = true;
                break;
            }
        }
        if (!Is_Added_Before_InWatched){
            movie.watchcount++;
            MoviesStatues.put(movie,true);
            Later.remove(movie);
            Watched.add(movie);
        }
    }

    public void getWatched() {
        System.out.println("Watched Movie List : ");
        if(Watched.isEmpty()) {
            System.out.println("No Movies Available");
        } else {
            for (int i = 0; i < Watched.size(); i++) {
                System.out.println(i + 1 + ") " + Watched.get(i).getMovieTitle());
            }
        }
    }

    public void removeMovieFromWatched(Movie movie) {
        MoviesStatues.put(movie,false);
        if(Watched.remove(movie)) {
            movie.watchcount--;
        }
        Watched.remove(movie);
    }


    /////////////////Later list

    public void addMovieToLater(Movie movie) {
        boolean Is_Added_Before_InLater = false;
        for (int i = 0; i < Later.size(); i++) {
            if (Later.get(i).getMovieTitle().toLowerCase().equals(movie.getMovieTitle().toLowerCase())){
                Is_Added_Before_InLater = true;
                break;
            }
        }
        if (!Is_Added_Before_InLater){
            MoviesStatues.put(movie,false);
            Watched.remove(movie);
            Later.add(movie);
        }
    }

    public void getLater() {
        System.out.println("Watch Later Movie List : ");
        if(Later.isEmpty()) {
            System.out.println("No Movies Available");
        } else {
            for (int i = 0; i < Later.size(); i++) {
                System.out.println(i + 1 + ") " + Later.get(i).getMovieTitle());
            }
        }
    }

    public void removeMovieFromLater(Movie movie) {
        Later.remove(movie);
    }

    /********************** END OF needed to be tested *************************/

    /////////////////Subscription
    //2et2aked men en mafish haga 2et8aiaret fi el Subscription class men lama ziad 2eshta8al

    public void EditSubscription (int changedprice){ //the parameter is the new price plan he wants to subscribe to

        subscription.setPriceOfPlan(changedprice);
    }

    public void Cancel_Subscription()
    {
        subscription.setPriceOfPlan(0);
    }


//        public void Add_Subscription() lao 3az ie3mel add li Subscription i5osh 3ala el EditSubscription
//    {
//        subscription.setPriceOfPlan(0);
//    }


    //    public Subscription getSub(){  mesh faker eh lazmetha
//        sub.SatuesSubscription(getUser_ID());
//    }
//    public void setSub(Subscription sub) {
//        sub.
//
//    }

    /********************** setter and getter**********************/
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getTheme_preference() {
        return theme_preference;
    }

    public void setTheme_preference(String theme_preference) { //make sure that the theme_preference is lowercase
        if (theme_preference=="dark"||theme_preference=="light")//means use to .lowerCase or something like that
        {
            this.theme_preference = theme_preference;
        }
    }

}