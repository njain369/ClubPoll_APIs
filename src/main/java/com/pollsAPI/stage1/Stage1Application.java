package com.pollsAPI.stage1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.pollsAPI.stage1")
public class Stage1Application {

	public static void main(String[] args) {
		SpringApplication.run(Stage1Application.class, args);
	}

}
