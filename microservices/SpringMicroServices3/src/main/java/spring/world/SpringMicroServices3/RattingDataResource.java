package spring.world.SpringMicroServices3;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.world.SpringMicroServices3.model.Rating;
import spring.world.SpringMicroServices3.model.UserRating;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RattingDataResource {

    @RequestMapping("/{movieId}")
    public Rating getMovieRating(String movieId){
        return new Rating( "Porsuit of Happiness",6);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getMovieRatingByuserid(@PathVariable("userId") String userId){


     List<Rating> listRating = Arrays.asList(
          new Rating("Movie 1",3),
          new Rating("Movie 2",4)
     );

        UserRating userRating = new UserRating();
        userRating.setUserRatingList(listRating);

        return userRating;
    }
}
