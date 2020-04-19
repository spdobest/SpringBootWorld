package spm.spring.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import spm.spring.world.repository.UserRepository;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class MySqlWithJpaSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySqlWithJpaSecurityApplication.class, args);
    }
}
