package com.data;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class DataJpaTestTwoApplication implements CommandLineRunner,ServletContextInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaTestTwoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	}

	
	
}
