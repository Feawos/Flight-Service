package com.tus.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tus.flight.model.Flight;
import com.tus.flight.repo.FlightRepository;

@RestController
public class FlightController {

    private static final Logger log =
            LoggerFactory.getLogger(FlightController.class);

	@Autowired
	FlightRepository repo;

	@GetMapping("/flights")
	public List<Flight> getFlights() {
		return repo.findAll();

	}

}
