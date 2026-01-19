package com.tus.flight;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class FlightservicesApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(FlightservicesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FlightservicesApplication.class, args);
    }

    // This method will run after Spring Boot starts
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i <= 20; i++) {
            logger.info("Flight service log message #{}", i);
            Thread.sleep(500); // send log every 0.5 seconds
        }
    }
}
