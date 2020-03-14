package spring.world.SpringMicroServices1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.world.SpringMicroServices1.model.CatalogItem;
import spring.world.SpringMicroServices1.model.Rating;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(String userId){

        // get all rated Movie IDS
        // for each Movie ID, call Movie info Service and get Details
        // put them all together

        List<Rating> listRating = Arrays.asList(
          new Rating("Movie 1",3),
          new Rating("Movie 2",4)
        );

        return listRating.stream().map(rating -> new CatalogItem("Porsuit of Happiness","adasdasd",5))
                .collect(Collectors.toList());

//        return Collections.singletonList(
//                new CatalogItem("Porsuit of Happiness","adasdasd",5)
//        );
    }
}
