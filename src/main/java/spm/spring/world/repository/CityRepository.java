package spm.spring.world.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spm.spring.world.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}