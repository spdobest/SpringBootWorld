package spring.world.SpringMicroServices1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import spring.world.SpringMicroServices1.model.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {


    @Autowired
    private SpringMicroServices1Application springMicroServices1Application;

    /**
     * It run the applicationname. jar file in server
     * you can run this application by command line like this
     *
     * java - Dserver.port=8082 -jar movie-catalog-service-0.0.1-SNAPSHPT.jar
     */

    @Autowired // is Consumer and @Bean is Producer
    private  RestTemplate restTemplate;

   // (RestTemplate is going to be Depricated, so we will use WebClient )

    @Autowired
    private WebClient.Builder webClientBuilder;



    @RequestMapping("/{userId}")
    public CatalogResponse getCatalogByuserid(@PathVariable("userId") String userId){

        // get all rated Movie IDS
        // for each Movie ID, call Movie info Service and get Details
        // put them all together

//        List<Rating> listRating = Arrays.asList(
//          new Rating("Movie 1",3),
//          new Rating("Movie 2",4)
//        );

//        UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId, UserRating.class);
        UserRating userRating = restTemplate.getForObject("http://movie-rating-service/ratingsdata/users/"+userId, UserRating.class);


        CatalogResponse catalogResponse = new CatalogResponse();



        List<CatalogItem> catalogItemList =  userRating.getUserRatingList().stream().map(rating -> {
//            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieID(), Movie.class);
            Movie movie = webClientBuilder.build()
                    .get()
//                    .uri("http://localhost:8082/movies/"+rating.getMovieID())
                    .uri("http://movie-info-service/movies/"+rating.getMovieID())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
            return new CatalogItem(movie.getMovieName(),movie.getMovieDesc(),rating.getRating());
        })
                .collect(Collectors.toList());

        catalogResponse.setListCatalog(catalogItemList);

        return catalogResponse;
    }
}
