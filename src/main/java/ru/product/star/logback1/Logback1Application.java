package ru.product.star.logback1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Logback1Application {

	private static final Logger logger = LoggerFactory.getLogger(Logback1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Logback1Application.class, args);

		logger.debug("This is a debug message");
		logger.info("This is an info message");
	}
}