package com.flightmanagement.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightmanagement.dto.Booking;
import com.flightmanagement.dto.Passenger;
import com.flightmanagement.dto.ScheduledFlight;
import com.flightmanagement.dto.User;
import com.flightmanagement.exception.BadRequestException;
import com.flightmanagement.exception.ResourceNotFoundException;
import com.flightmanagement.service.BookingService;
import com.flightmanagement.service.PassengerService;
import com.flightmanagement.service.ScheduledFlightService;
import com.flightmanagement.service.UserService;


@CrossOrigin(origins = "*")
@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	PassengerService passengerService;
	
	@Autowired
	ScheduledFlightService scheduledFlightService;
	
	@Autowired
	UserService userService;

	
	@PostMapping(value="/makeBooking")
	public Booking addBooking(@Valid @RequestBody()Booking booking)
	{
		booking.setBookingDate(LocalDate.now());
		for(Passenger passenger : booking.getPassengerList())
			passengerService.addPassenger(passenger);
		Booking bookingDone = bookingService.addBooking(booking);
		return bookingDone;
	}
	
	@GetMapping(value="/getBooking/{bookingId}",produces="application/json")
	public Booking getBooking(@PathVariable long bookingId)
	{
		Optional<Booking> booking = bookingService.getBooking(bookingId);
		try
		{
			if(!booking.isPresent())
			{
				throw new ResourceNotFoundException(bookingId+" booking id does not exit");
			}
		}
		catch(ResourceNotFoundException e)
		{
			e.printStackTrace();
		}
		return booking.get();
	}

	@GetMapping(value="/getAllBooking/{userId}",produces="application/json")
	public List<Booking> getAllBooking(@PathVariable long userId)
	{
		List<Booking> bookingList = bookingService.getAllBooking(userId);
		try 
		{
			if(bookingList.isEmpty())
			{
				throw new BadRequestException(userId+" userId does not exit");
			}
		} 
		catch (BadRequestException e) {
			e.printStackTrace();
		}
		return bookingList;
	}

	@DeleteMapping(value="/deleteBooking/{bookingId}")
	public String deleteBooking(@PathVariable long bookingId)
	{
		Optional<Booking> booking = bookingService.getBooking(bookingId);
		try
		{
			if(!booking.isPresent())
			{
				throw new ResourceNotFoundException(bookingId+" booking id does not exit");
			}
		}
		catch(ResourceNotFoundException e)
		{
			e.printStackTrace();
		}
		String d= bookingService.deleteBooking(bookingId);
		System.out.println(d);
		return d;
	}
	
		@GetMapping(value="/getAllScheduledFlights",produces="application/json")
		public List<ScheduledFlight> getAllFlightSchedules()
		{
			List<ScheduledFlight> flightScheduleList = scheduledFlightService.getAllFlightSchedules();
			return flightScheduleList;
		}
		
		@GetMapping(value="/getFlightSchedule/{scheduleId}",produces="application/json")
		public ScheduledFlight getFlightSchedule(@PathVariable int scheduleId)
		{
			Optional<ScheduledFlight> flightSchedule= scheduledFlightService.getFlightSchedule(scheduleId);
		    return flightSchedule.get();
		}
		
		@GetMapping(value="/getUser/{userId}",produces="application/json")
		public User getUser(@PathVariable long userId)
		{
			Optional<User> user= userService.getUser(userId);
		    return user.get();
		}
}
