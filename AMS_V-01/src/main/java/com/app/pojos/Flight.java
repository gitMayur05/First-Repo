package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "flight")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(column = @Column(name = "flight_id"), name = "id")
public class Flight extends BaseEntity 
{

	@Column(name = "flight_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private AircraftType flightType;
	
	@Column(nullable = false)
	private int capacity;
	
	@Column(name = "departure_city", length = 25, nullable = false)
	private String departureCity;
	
	@Column(name = "departure_date", nullable = false)
	private LocalDate departureDate;
	
	@Column(name = "departure_time", nullable = false)
	private LocalTime departureTime;

	@Column(name = "arrival_city", length = 25, nullable = false)
	private String arrivalCity;
	
	@Column(name = "arrival_date", nullable = false)
	private LocalDate arrivalDate;
	
	@Column(name = "arrival_time", nullable = false)
	private LocalTime arrivalTime;
	
	@Column(nullable = false)
	private double duration;
	
//	@OneToMany(mappedBy = "ticket_id", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Ticket> tickets = new ArrayList<>();
	
	
	@Override
	public String toString() 
	{
		return "Flight [id="+getId()+", flightType=" + flightType + ", capacity=" + capacity + ", departureCity=" + departureCity
				+ ", departureDate=" + departureDate + ", departureTime=" + departureTime + ", arrivalCity="
				+ arrivalCity + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", duration="
				+ duration + "]";
	}

}
