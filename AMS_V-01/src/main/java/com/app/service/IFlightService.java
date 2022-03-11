package com.app.service;

import java.util.List;

import com.app.pojos.Flight;

public interface IFlightService 
{
	//method to get a list of all available flights
	List<Flight> getAllFlights();
	
	//method to insert new flight
	Flight insertNewFLight(Flight newFlight);
	
	//method to cancel a flight
	String deleteFlight(int fId);
	
	//method to search a particular flight by id
	Flight getFlightDetailsById(int flightId);
	
	//method to update a particular flight
	Flight updateFlight(Flight detachedFlight);
	
	//method to search flight by source and destination location
	List<Flight> getFlightBySrcAndDest(String src, String dest);
}
