package com.flightmanagement.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.flightmanagement.dto.Booking;
import com.flightmanagement.dto.Passenger;
import com.flightmanagement.exception.ResourceNotFoundException;
import com.flightmanagement.service.BookingService;
import com.flightmanagement.service.PassengerService;


@CrossOrigin(origins = "*")
@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	PassengerService passengerService;

	
	@PostMapping(value="/makeBooking")
	public String addBooking(@Valid @RequestBody()Booking booking)
	{
		for(Passenger passenger : booking.getPassengerList())
			passengerService.addPassenger(passenger);
		Booking b = bookingService.addBooking(booking);
		return "{bookingId is :" + b.getBookingId() + "}";
	}
	
	@GetMapping(value="/getBooking/{bookingId}",produces="application/json")
	public Optional<Booking> getBooking(@PathVariable long bookingId) throws ResourceNotFoundException
	{
		if(bookingService.getBooking(bookingId).isPresent())
		{
		return bookingService.getBooking(bookingId);
		}
		throw new ResourceNotFoundException(bookingId+" booking id does not exit");
	}

	@GetMapping(value="/getAllBooking/{userId}",produces="application/json")
	public List<Booking> getAllBooking(@PathVariable long userId)
	{
		return bookingService.getAllBooking(userId);
	}

	@DeleteMapping(value="/deleteBooking/{bookingId}")
	public String deleteBooking(@PathVariable long bookingId) throws ResourceNotFoundException
	{
		if(bookingService.getBooking(bookingId).isPresent())
		{
		return bookingService.deleteBooking(bookingId);
		}
		throw new ResourceNotFoundException(bookingId+" booking id does not exit");
	}
	
	
}
