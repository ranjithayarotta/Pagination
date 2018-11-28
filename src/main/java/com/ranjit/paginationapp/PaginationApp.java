package com.ranjit.paginationapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
@Controller
public class PaginationApp implements CommandLineRunner {
	private static final Logger LOGGER = LogManager.getLogger(PaginationApp.class);

	public static void main(String[] args) {
		SpringApplication.run(PaginationApp.class, args);

	}

	public void run(String... args) throws Exception {
	LOGGER.debug("BOOT STARTED UP NEW VERSION...");

	}

	@GetMapping("/")
	public String getScrollPage() {
		return "scroll";
	}
}