package spring.world.SpringMicroServices3.model;

public class Rating {

    private int movieID;

    private int rating;


    public Rating() {
        super();
    }

    public int getRating() {
        return rating;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public Rating(String movieName, int rating) {
        this.rating = rating;
        this.movieName = movieName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    private String movieName;
}
