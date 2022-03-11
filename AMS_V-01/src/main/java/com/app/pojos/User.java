package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(column = @Column(name = "user_id"), name = "id")
public class User extends BaseEntity 
{
	// To Rethink about a user and passenger
	// table******************************************************************************
	@Column(length = 50, name = "user_name")
	private String name;

	@Column(length = 50, unique = true, nullable = false)
	@Email
	@NotBlank(message = "Email cannot be empty")
	private String email;

	@NotBlank(message = "Password cannot be empty")
	@Column(length = 50, nullable = false)
	private String password;

	@NotBlank(message = "Mobile number cannot be blank")
	@Column(length = 10, unique = true, nullable = false, name = "mobile_number")
	private String mobileNumber;

	@NotBlank
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private List<Passenger> passengers = new ArrayList<Passenger>();

	
	@Override
	public String toString() 
	{
		return "User [id="+getId()+", name=" + name + ", email=" + email + ", password=" + password + ", mobileNumber=" + mobileNumber
				+ ", role=" + role + "]";
	}

}
