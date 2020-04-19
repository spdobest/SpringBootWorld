package spm.spring.world.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spm.spring.world.dto.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String username);
}
