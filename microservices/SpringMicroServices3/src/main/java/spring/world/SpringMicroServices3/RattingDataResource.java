package spring.world.SpringMicroServices3;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.world.SpringMicroServices3.model.Rating;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RattingDataResource {
    @RequestMapping("/{movieId}")
    public Rating getMovieRating(String movieId){

        return new Rating( "Porsuit of Happiness",6);

    }
}
