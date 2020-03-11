package spm.spring.world.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spm.spring.world.model.Alien;

@Repository
public interface AlienRepo extends CrudRepository<Alien, Integer> {

}