package com.app.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AircraftType 
{
	CHARTER(12), AIRBUS(40), JUMBOJET(100);
	private int capacity;
	
}
	
