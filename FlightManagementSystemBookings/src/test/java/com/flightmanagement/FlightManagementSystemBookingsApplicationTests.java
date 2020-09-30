package com.flightmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightmanagement.dto.Booking;
import com.flightmanagement.dto.Passenger;
import com.flightmanagement.dto.ScheduledFlight;
import com.flightmanagement.dto.User;
import com.flightmanagement.service.BookingService;
import com.flightmanagement.service.PassengerService;

@SpringBootTest
class FlightManagementSystemBookingsApplicationTests {
	@Autowired
	BookingService bookingService;

	@Autowired
	PassengerService passengersService;
	

	@Test
	void addBookingdetailsTest() throws ParseException {
		LocalDate localDate = LocalDate.of(2020, 10, 1);

		List<Passenger> passengerslist = bookingService.getBooking(172).get().getPassengerList();
		User user1 = bookingService.getBooking(172).get().getUser();
		ScheduledFlight flightschedule1 = bookingService.getBooking(172).get().getScheduledFlight();
		Booking book = new Booking(user1, flightschedule1, passengerslist, localDate);
		Booking book1 = bookingService.addBooking(book);
		
		//assertEquals(book1.getBookingId(),101);
		assertEquals(book1.getUser().getUserId(),user1.getUserId());
	}

	@Test
	void getBookingTest()
	{
		Booking booking = bookingService.getBooking(172).get();
		assertEquals(172,booking.getBookingId());
	}

	@Test
	void getAllBookingTest()
	{
		List<Booking> bookingList = bookingService.getAllBooking(1);
		assertEquals(0,bookingList.size());
	}
	
	@Test
	void deleteBookingTest()
	{
		String a = bookingService.deleteBooking(205);
		System.out.println(a);
		String b = "deleted sucessfully";
		assertTrue(a.equals(b));
	}

}
