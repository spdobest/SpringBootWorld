package spring.world.SpringMicroServices2;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.world.SpringMicroServices2.model.Movie;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieRespource {
    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(String movieId){
            return    new Movie(1,"Porsuit of Happiness","Movie Desc");
    }
}