package spm.spring.world.repository;

import org.springframework.data.repository.Repository;

import java.util.List;


public interface BaseRepository<T> extends Repository<T, Integer> {

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    List<T> findAll();
}