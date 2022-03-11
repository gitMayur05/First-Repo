package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(column = @Column(name = "ticket_id"), name = "id")
public class Ticket extends BaseEntity
{
	@Column(length = 50, nullable = false)
	private String source;
	
	@Column(length = 50, nullable = false)
	private String destination;

	@Column(name = "ticket_date", nullable = false)
	private LocalDate ticketDate;

	@Column(name = "travelling_date", nullable = false)
	private LocalDate travellingDate;

	@Column(nullable = false)
	private LocalTime departureTime;

	@Column(nullable = false)
	private LocalTime arrivalTime;

	@Column(length = 15, nullable = false)
	private SeatClass seatClass;
	
	@ManyToOne()
	@JoinColumn(name = "flight_id", nullable = false)
	private Flight flight;
	
	@OneToOne(mappedBy = "ticket")
	private Passenger passenger;
	
	@Override
	public String toString() 
	{
		return "Ticket [id="+getId()+",source=" + source + ", destination=" + destination + ", ticketDate=" + ticketDate
				+ ", travellingDate=" + travellingDate + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", seatClass=" + seatClass + "]";
	}

}
