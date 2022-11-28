package com.newsblock.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.newsblock.api.*")
@ComponentScan(basePackages = { "com.newsblock.api.*" })
@EntityScan("com.newsblock.api.*")  
public class NewsBlockAPI extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(NewsBlockAPI.class, args);
	}

}