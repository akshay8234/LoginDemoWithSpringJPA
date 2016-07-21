package com.demoSpringJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
@EnableJpaRepositories("com.demoSpringJPA.repository")
@ComponentScan("com")
public class DemoSpringJPAApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringJPAApplication.class, args);
	}
}
