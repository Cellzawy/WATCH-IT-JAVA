import java.util.ArrayList;


public class Admin extends User{

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
        movie.setRatings(null);
    }
    public void removeRating(Movie movie, User user) {
        Rating[] ratings = movie.getRatings();
        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i] != null && ratings[i].getUser() == user) {
                ratings[i] = null;
                break;
            }
        }
    }
    public void suspendAccount(User user) {
        user.suspended = true;
    }
    public void unsuspendAccount(User user) {
        user.suspended = false;
    }
    public String getMostRevMonth() {
        return "h";
    }
    public String getMostSubbedPlan() {
        return "h";
    }

}