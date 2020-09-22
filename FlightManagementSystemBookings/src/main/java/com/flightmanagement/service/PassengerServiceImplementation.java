package com.flightmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightmanagement.dao.PassengerDao;
import com.flightmanagement.dto.Passenger;

@Service
public class PassengerServiceImplementation implements PassengerService {

	@Autowired
	PassengerDao passengerDao;
	
	@Override
	public Optional<Passenger> getPassenger(long passengerId) {
		return passengerDao.findById(passengerId);
	}

	@Override
	public List<Passenger> getAllPassengers() {
		return passengerDao.findAll();
	}

	@Override
	public Passenger addPassenger(Passenger passenger) {
		return passengerDao.save(passenger);
	}

	@Override
	public void updatePassenger(Passenger passenger) {
		if(passengerDao.findById(passenger.getPassengerId()).isPresent())
			passengerDao.save(passenger);
	}

	@Override
	public void deletePassenger(long passengerId) {
		if(passengerDao.findById(passengerId).isPresent())
			passengerDao.deleteById(passengerId);
	}

}
