package spm.spring.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spm.spring.client.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);
}
