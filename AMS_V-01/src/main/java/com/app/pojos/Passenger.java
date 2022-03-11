package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passenger")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(column = @Column(name = "passenger_id"), name = "id")
public class Passenger extends BaseEntity 
{
	@Column(length = 50)
	private String name;

	@Column(length = 100)
	private String address;
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "seat_pref", length = 15)
	private SeatPreference seatPref;

	@Column(name = "is_pwd")
	private boolean isPWD;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(length = 25)
	@Enumerated(EnumType.STRING)
	private IdentificationDetails uidDocument;

	@Column(length = 15)
	private String uidDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ticket_id", nullable = false)
	private Ticket ticket;
	
	@Override
	public String toString() 
	{
		return "Passenger [id="+getId()+", name=" + name + ", address=" + address + ", gender=" + gender + ", seatPref=" + seatPref
				+ ", isPWD=" + isPWD + ", dateOfBirth=" + dateOfBirth + ", uidDocument=" + uidDocument + ", uidDetails="
				+ uidDetails + "]";
	}

}

