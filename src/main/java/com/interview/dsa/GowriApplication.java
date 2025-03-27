package com.interview.dsa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

import java.time.Instant;

@SpringBootApplication
public class GowriApplication {

	private static final Logger logger = LoggerFactory.getLogger(GowriApplication.class);

	// Track application start time and stop time
	private Instant startTime;

	public static void main(String[] args) {
		SpringApplication.run(GowriApplication.class, args);
	}

	// Listener for ApplicationStartedEvent (When application is starting)
	@EventListener(ApplicationStartedEvent.class)
	public void onApplicationStart() {
		startTime = Instant.now();
		logger.info("Application started at: " + startTime);
	}

	// Listener for ApplicationReadyEvent (When application is fully started and ready)
	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReady() {
		logger.info("Application is running.");
	}

	// Listener for ContextClosedEvent (When application is stopping)
	@EventListener(ContextClosedEvent.class)
	public void onApplicationStop() {
		Instant stopTime = Instant.now();
		logger.info("Application stopped at: " + stopTime);
		if (startTime != null) {
			long duration = stopTime.getEpochSecond() - startTime.getEpochSecond();
			logger.info("Application ran for: " + duration + " seconds.");
		}
	}
}
