import java.lang.reflect.Array;
import java.util.*;


public class User {
    //fields

    ArrayList<Movie> Watched = new ArrayList<Movie>();
    ArrayList<Movie> Later = new ArrayList<Movie>();
    private final String User_ID;
    private String first_name;
    private String last_name;
    private String user_email;
    private String user_password;

    public Subscription sub = new Subscription();
    private String theme_preference;


    //Methods


    public User() {
        this.User_ID = UUID.randomUUID().toString(); // generate unique id for each user
    }

    public String getUser_ID() {
        return User_ID;
    }



    public void check_movie(Movie movie)//to be sure there is not any duplicate in the watched list
    // and the watched later list
    {
        if (movie.getIs_Watched()) {

        }
    }

    public void Cancel_Subscription()
    {
        sub=null;
    }

    public void Add_Subscription()
    {
        sub=new Subscription();
    }



    //setter and getter
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

//    public Subscription getSub(){
//        sub.SatuesSubscription(getUser_ID());
//    }
//    public void setSub(Subscription sub) {
//        sub.
//
//    }

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

    public String getTheme_preference() {
        return theme_preference;
    }

    public void setTheme_preference(String theme_preference) { //make sure that the theme_preference is lowercase
        if (theme_preference=="dark"||theme_preference=="light")//means use to .lowerCase or something like that
        {
            this.theme_preference = theme_preference;
        }
    }

    public void SetUserRating(Movie movie,int rating) { //the movie must be on the watched list first
        boolean isReallyWatched = false;
        if (rating <= 10 && rating >= 0) {
            for (int i = 0; i < Watched.size(); i++) { //cheking if the movie with its name is on the watched list
                if (Watched.get(i).getMovieTitle().equals(movie.getMovieTitle())) {
                    isReallyWatched = true;
                    break;
                }
            }
        }

        if (isReallyWatched) {
            for (int i = 0; i < Watched.size(); i++) {
                if (movie.getMovieTitle().equals(Watched.get(i).getMovieTitle())) {
                    Watched.get(i).user_Rating = rating;
                    Watched.get(i).Ratings.add((float)rating);
                }
            }

        } else {
            System.out.println("Movie wasn't watched");
        }
    }

    public void getUserRatingForMovie() {
        System.out.println("Watched Movie List : ");
        if(Watched.isEmpty()) {
            System.out.println("No Movies Available");
        } else {
            for (int i = 0; i < Watched.size(); i++) {
                if(Watched.get(i).user_Rating == -1) {
                    System.out.println(i + 1 + ") " + Watched.get(i).getMovieTitle() + " not rated");
                } else {
                    System.out.println(i + 1 + ") " + Watched.get(i).getMovieTitle() + " " + Watched.get(i).user_Rating);
                }
            }
        }
    }

    public void addMovieToWatched(Movie movie) {
        Later.remove(movie);
        Watched.add(movie);
    }

    public void addMovieToLater(Movie movie) {
        Watched.remove(movie);
        Later.add(movie);
    }

    public void removeMovieFromWatched(Movie movie) {
        Watched.remove(movie);
    }

    public void removeMovieFromLater(Movie movie) {
        Later.remove(movie);
    }
}