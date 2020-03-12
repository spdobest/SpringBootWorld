package spm.spring.world.repository;

import spm.spring.world.model.user.User;

import java.util.List;

public interface UserRepository extends BaseRepository<User> {

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    List<User> findAll();
}
