package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IFlightRepository;
import com.app.pojos.Flight;

@Service
@Transactional
public class FlightServiceImpl implements IFlightService
{
	@Autowired
	private IFlightRepository flightRepo;
	
	@Override
	public List<Flight> getAllFlights() 
	{		
		return flightRepo.findAll();
	}

	@Override
	public Flight insertNewFLight(Flight newFlight) 
	{	
		return flightRepo.save(newFlight);
	}

	@Override
	public String deleteFlight(int fId) 
	{
		//check if flight with given id exists
		if(flightRepo.existsById(fId))
		{
			flightRepo.deleteById(fId);
			return "Flight with Id: "+fId+" cancelled!!";
		}
		throw new RuntimeException("Flight with Id: "+fId+" not found!!");
	}
	
	@Override
	public Flight updateFlight(Flight detachedFlight) 
	{
		return flightRepo.save(detachedFlight);
	}
	
	@Override
	public Flight getFlightDetailsById(int flightId) 
	{
		return flightRepo.findById(flightId).orElseThrow(() -> new RuntimeException("Flight with "+flightId+" not found!!!"));
	}

	@Override
	public List<Flight> getFlightBySrcAndDest(String src, String dest) 
	{		
		return flightRepo.findByDepartureCityAndArrivalCity(src, dest).orElseThrow(() -> new RuntimeException("No Flights from "+src+ " to "+dest+" found"));
	}

		
	
}
