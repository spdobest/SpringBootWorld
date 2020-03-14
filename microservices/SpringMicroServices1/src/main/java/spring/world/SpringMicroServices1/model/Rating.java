package spring.world.SpringMicroServices1.model;

public class Rating {
    private int rating;

    public int getRating() {
        return rating;
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
