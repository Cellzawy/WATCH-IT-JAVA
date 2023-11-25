import java.lang.reflect.Array;
import java.util.*;


public class User {
    //fields

    private int watchedCount = 0; // how many watched movies
    private int sizeOfWatched = 0; // size of watched[]

    private int laterCount = 0; // how many watched movies
    private int sizeOfLater = 0; // size of Movie[]

    private final String User_ID;
    private String first_name;
    private String last_name;
    private String user_email;
    private String user_password;

    public Subscription sub = new Subscription();
//    private Movie movie = new Movie();

    Movie[] Later = new Movie[1];
    Movie[] Watched = new Movie[1];
    //    int number_of_movie_to_watch_later = 1;
//    private String[] watch_later_list = new String[number_of_movie_to_watch_later];
//    // 7ateto size-1 3ashan 2a5li el added movieTitle fi el 2a5er wi 2ashil e7timal eno lao da5al
//    // el max number of movie eli hoa number_of_movie_to_watch_later wi hoa bie3mel el account
//
//    int number_of_movie_watched = 1;
//    private String[] watched_list = new String[number_of_movie_to_watch_later];
    private String theme_preference;


    //Methods


    public User() {
        this.User_ID = UUID.randomUUID().toString(); // generate unique id for each user
    }

    public String getUser_ID() {
        return User_ID;
    }

//    public void AddToWatch_later_list(Movie movie) {
//        for (int i = 0; i < number_of_movie_to_watch_later-1; i++) { //if the added movie is already in the watch later
//            if (watch_later_list[i].equals(movie.getMovieTitle())) {          // break from the function
//                return;
//            }
//        }
//        watch_later_list[number_of_movie_to_watch_later-1] = movie.getMovieTitle();
//        number_of_movie_to_watch_later++;
//
//    }
//
//    public void AddToWatched_list(Movie movie) {
//        for (int i = 0; i < number_of_movie_watched-1; i++) { //if the added movie is already in the watched
//            if (watched_list[i].equals(movie.getMovieTitle())) {// break from the function
//                return;
//            }
//        }
//        watch_later_list[number_of_movie_watched-1] = movie.getMovieTitle();
//        number_of_movie_watched++;
//
//    }

    public void changeSizeOfWatched(boolean condition) {
        //declares a temp[] array
        Movie temp[] = null;
        if (watchedCount == sizeOfWatched) {
            //initialize a double size array of array
            if (condition) {
                temp = new Movie[sizeOfWatched + 1];
                for (int i = 0; i < sizeOfWatched; i++) {
                    //copies all the elements of the old array
                    temp[i] = Watched[i];
                }
            } else if (!condition) {
                temp = new Movie[Watched.length - 1];
                for (int i = 0; i < Watched.length - 1; i++) {
                    //copies all the elements of the old array
                    temp[i] = Watched[i];
                }
            }
        }
        Watched = temp;
        if (condition) {
            sizeOfWatched += 1;
        } else {
            sizeOfWatched -= 1;
        }
    }

    public void addMovieToWatched(Movie movie) {
        //compares if the number of elements is equal to the size of the array or not
        if(movie.getMovieTitle() != null) {
            boolean found = false;
            for (int i = 0; i < watchedCount; i++) {
                if (Watched[i].getMovieTitle().equals(movie.getMovieTitle().toLowerCase())) {
                    found = true;
                }
            }
            //invoking the growSize() method that creates an array of 2X the size
            if (!found) {
                changeSizeOfWatched(true);
                Watched[watchedCount] = movie;
                watchedCount++;
            }
        }
    }

    public void deleteMovieFromWatched(String movieName) {
        if(watchedCount > 0) {
            boolean found = false;
            int index = -1;
            for (int i = 0; i < watchedCount; i++) {
                if (Watched[i].getMovieTitle().equals(movieName.toLowerCase())) {
                    found = true;
                    index = i;
                }
            }
            for (int i = index; i < sizeOfWatched - 1; i++) {
                //shifting all the elements to the left from the specified index
                Watched[i] = Watched[i + 1];
            }
            if (found) {
                changeSizeOfWatched(false);
                watchedCount--;
            }
        }
    }

    public void changeSizeOfLater(boolean condition) {
        //declares a temp[] array
        Movie temp[] = null;
        if (laterCount == sizeOfLater) {
            //initialize a double size array of array
            if (condition) {
                temp = new Movie[sizeOfLater + 1];
                for (int i = 0; i < sizeOfLater; i++) {
                    //copies all the elements of the old array
                    temp[i] = Later[i];
                }
            } else if (!condition) {
                temp = new Movie[sizeOfLater - 1];
                for (int i = 0; i < Later.length - 1; i++) {
                    //copies all the elements of the old array
                    temp[i] = Later[i];
                }
            }
        }
        Later = temp;
        if (condition) {
            sizeOfLater += 1;
        } else {
            sizeOfLater -= 1;
        }
    }

    public void addMovieToLater(Movie movie) {
        if(movie.getMovieTitle() != null) {
            boolean found = false;
            for (int i = 0; i < laterCount; i++) {
                if (Later[i].getMovieTitle().equals(movie.getMovieTitle().toLowerCase())) {
                    found = true;
                }
            }
            //invoking the growSize() method that creates an array of 2X the size
            if (!found) {
                changeSizeOfLater(true);
                Later[laterCount] = movie;
                laterCount++;
            }
        }
    }

    public void deleteMovieFromlater(String movieName) {
        if(laterCount > 0) {
            boolean found = false;
            int index = -1;
            for (int i = 0; i < laterCount; i++) {
                if (Later[i].getMovieTitle().equals(movieName.toLowerCase())) {
                    found = true;
                    index = i;
                }
            }
            for (int i = index; i < sizeOfLater - 1; i++) {
                //shifting all the elements to the left from the specified index
                Later[i] = Later[i + 1];
            }
            if (found) {
                changeSizeOfWatched(false);
                laterCount--;
            }
        }
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

    /*public void getWatch_later_list() {
        for (int i = 0; i < number_of_movie_to_watch_later; i++) {
            System.out.println((i+1)+") "+watch_later_list[i]);
        }



    }

//    public void setWatch_later_list(String[] watch_later_list) {
//
//        useless for now
//
//    }

    public void getWatched_list() {
        for (int i = 0; i < number_of_movie_watched; i++) {
            System.out.println((i+1)+") "+watched_list[i]);
        }
    }*/

//    public void setWatched_list(String[] watched_list) {
//        also useless for now
//    }

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
