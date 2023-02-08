package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class BookApiApplication implements CommandLineRunner {

	private static final Log LOGGER = LogFactory.getLog(BookApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookApiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("runner");
	}

}
