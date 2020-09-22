package com.flightmanagement.service;

import java.util.List;
import java.util.Optional;

import com.flightmanagement.dto.Passenger;

public interface PassengerService {
	
	public Optional<Passenger> getPassenger(long passengerId);
	
	public List<Passenger> getAllPassengers();
	
	public Passenger addPassenger(Passenger passenger);
	
	public void updatePassenger(Passenger passenger);
	
	public void deletePassenger(long passengerId);

}
