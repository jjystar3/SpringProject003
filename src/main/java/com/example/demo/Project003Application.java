package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//JPA의 리스너 기능을 활성화
//이 어노테이션이 있어야 @createdDate의 기능이 수행됨
@EnableJpaAuditing
@SpringBootApplication
public class Project003Application {

	public static void main(String[] args) {
		SpringApplication.run(Project003Application.class, args);
	}

}
