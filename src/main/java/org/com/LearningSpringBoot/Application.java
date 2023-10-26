package org.com.LearningSpringBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@SpringBootApplication

public class
Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}
}