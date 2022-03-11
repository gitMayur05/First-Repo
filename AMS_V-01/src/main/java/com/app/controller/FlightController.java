package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Flight;
import com.app.service.IFlightService;

@RestController
@RequestMapping("/flights")
public class FlightController 
{
	@Autowired
	private IFlightService flightService;
	
	public FlightController() 
	{
		System.out.println("In Flight Controller /=> Ctor");
	}
	
	//REST API end point to get all available flights  
	@GetMapping
	public ResponseEntity<?> fetchAllFlights()
	{
		System.out.println("In Flight Controller /=> fetchAllFlights");
		return ResponseEntity.status(HttpStatus.OK).body(flightService.getAllFlights());
	}
	
	//REST API end point to add a new flight
	@PostMapping
	public ResponseEntity<?> addNewFlight(@RequestBody Flight newFlight)
	{
		System.out.println("In Flight Controller /=> addNewFlight "+newFlight);
		return ResponseEntity.status(HttpStatus.CREATED).body(flightService.insertNewFLight(newFlight));
	}
	
	//REST API end point to cancel a flight
	@DeleteMapping("/{flightId}")
	public String cancelFlight(@PathVariable int flightId)
	{
		System.out.println("In Flight Controller /=> cancelFlight");
		try
		{
			return flightService.deleteFlight(flightId);
		}
		catch(RuntimeException e)
		{
			return e.getMessage();
		}
	}
	
	//REST API end point to get a particular flight by id
	@GetMapping("/{flightId}")
	public ResponseEntity<?> getFlightDetailsById(@PathVariable int flightId)
	{
		System.out.println("In Flight Controller /=> getFlightDetailsById");
		return ResponseEntity.ok(flightService.getFlightDetailsById(flightId));
	}
	
	//REST API end point to update flight details
	@PutMapping
	public Flight updateFlightDetails(@RequestBody Flight detachedFlight)
	{
		System.out.println("In Flight Controller /=> updateFlightDeatils");
		return flightService.updateFlight(detachedFlight);
	}
	
	
	//REST API end point to get flight by source and destination
	@GetMapping("/source/{src}/destination/{dest}")
	public ResponseEntity<?> getFlightBySourceAndDestination(@PathVariable String src, @PathVariable String dest)
	{
		System.out.println("In Flight Controller /=> getFlightBySourceAndDestination");
		return ResponseEntity.ok(flightService.getFlightBySrcAndDest(src, dest));
	}

}
