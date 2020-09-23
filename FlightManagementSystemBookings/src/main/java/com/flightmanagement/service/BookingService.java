package com.flightmanagement.service;

import java.util.List;
import java.util.Optional;

import com.flightmanagement.dto.Booking;
import com.flightmanagement.exception.BadRequestException;


public interface BookingService {
	
	public Optional<Booking> getBooking(long bookingId);
	
	public List<Booking> getAllBooking(long userId);
	
	public Booking addBooking(Booking booking);
	
	public void modifyBooking(Booking booking);
	
	public String deleteBooking(long bookingId);
	
}
