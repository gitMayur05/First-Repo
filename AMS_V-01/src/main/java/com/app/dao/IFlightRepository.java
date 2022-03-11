package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Flight;

public interface IFlightRepository extends JpaRepository<Flight, Integer>
{
	Optional<List<Flight>> findByDepartureCityAndArrivalCity(String src , String dest);
}
