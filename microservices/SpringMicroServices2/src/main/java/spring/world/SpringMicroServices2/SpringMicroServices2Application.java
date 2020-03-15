package spring.world.SpringMicroServices2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringMicroServices2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroServices2Application.class, args);
	}

}
