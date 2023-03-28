package com.demo.postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootPostgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPostgresqlApplication.class, args);
	}
}
