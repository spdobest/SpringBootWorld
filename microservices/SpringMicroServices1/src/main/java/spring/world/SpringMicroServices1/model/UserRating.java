package spring.world.SpringMicroServices1.model;

import java.util.List;

public class UserRating {
    List<Rating> userRatingList;

    public UserRating() {
        super();
    }

    public List<Rating> getUserRatingList() {
        return userRatingList;
    }

    public void setUserRatingList(List<Rating> userRatingList) {
        this.userRatingList = userRatingList;
    }
}
