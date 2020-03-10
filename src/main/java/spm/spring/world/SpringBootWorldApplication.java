package spm.spring.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="spm.spring.world.dao")
@SpringBootApplication
public class SpringBootWorldApplication {
// https://www.youtube.com/playlist?list=PL093Ac14AFw0ie8-POofboX3IUA8KhCVi
	// Search API collection in PostMan( with id : sp.dobest@gmail.com) - SpringBootRest

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWorldApplication.class, args);
	}

}
