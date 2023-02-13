package fr.greta92.DomesServiceSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DomesServiceSpringApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(DomesServiceSpringApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(DomesServiceSpringApplication.class);
		sa.run(args);
	}
}
