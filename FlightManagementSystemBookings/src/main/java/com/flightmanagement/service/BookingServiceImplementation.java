package com.flightmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightmanagement.dao.BookingDao;
import com.flightmanagement.dto.Booking;

@Service
public class BookingServiceImplementation implements BookingService {

	@Autowired
	BookingDao bookingDao;
	@Override
	public Optional<Booking> getBooking(long bookingId) {
		return bookingDao.findById(bookingId);
	}

	//view booking by userId
	@Override
	public List<Booking> getAllBooking(long userId) {
            return bookingDao.findAll().stream()
                    .filter(x -> x.getUser().getUserId() == userId)
                    .collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public Booking addBooking(Booking booking) {
		return bookingDao.save(booking);
	}

	@Override
	public void modifyBooking(Booking booking) {
		if(bookingDao.findById(booking.getBookingId()).isPresent())
			bookingDao.save(booking);
	}

	@Override
	public String deleteBooking(long bookingId) {
		if(bookingDao.findById(bookingId).isPresent())
			bookingDao.deleteById(bookingId);
		return "deleted successfully";
	}

}
