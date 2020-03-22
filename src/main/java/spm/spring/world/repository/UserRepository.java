package spm.spring.world.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spm.spring.world.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
