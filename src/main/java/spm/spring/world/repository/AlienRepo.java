package spm.spring.world.repository;

import org.springframework.data.repository.CrudRepository;
import spm.spring.world.model.Alien;

public interface AlienRepo extends CrudRepository<Alien,Integer> {

}