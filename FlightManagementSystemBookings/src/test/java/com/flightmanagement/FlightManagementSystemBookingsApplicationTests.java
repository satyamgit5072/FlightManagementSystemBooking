package com.flightmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightmanagement.dto.Airport;
import com.flightmanagement.dto.Booking;
import com.flightmanagement.dto.Flight;
import com.flightmanagement.dto.Passenger;
import com.flightmanagement.dto.Schedule;
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
	
//	@Test
//	void addBookingdetailsTest() throws ParseException {
//		String dateInString = "7-Jun-2021";
//		String dateInString1 = "9-Jun-2021";
//		String dateInString2 = "9-Jun-2021";
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//		Date date1 = formatter.parse(dateInString);
//		Date date2 = formatter.parse(dateInString1);
//		Date date3 = formatter.parse(dateInString2);
//		
//		List<Passenger> passenger = new ArrayList<Passenger>();
//		Flight flight=new Flight( "Spicey", "spic123",225);
//		Airport airport1=new Airport("Kolkata","Kempegowda","Kkr");
//		Airport airport2 = new Airport("Ahmedabad","kitat","Ahed");
//		Schedule schedule = new Schedule(airport1,airport2,date2,date3);
//		ScheduledFlight flightschedule = new ScheduledFlight(flight,221,schedule);
//		User user=new User(164,"varun","varun@23",987584478,"varun78@gmail.com","customer");
//		Booking book=new Booking(user,flightschedule,passenger,date1);
//		Booking book1=service.addBooking(book);
//		assertEquals(book1.getBookingId(),164);
//	}
	

	@Test
	void getBookingTest() {
	assertEquals(22,bookingService.getBooking(22).get().getBookingId());
	}

	@Test
	void getAllBookingTest()
	{
		assertEquals(1,bookingService.getAllBooking(2).size());
	}
	
	@Test
	void deleteBookingTest()
	{
		String a = bookingService.deleteBooking(43);
		String b = "deleted successfully";
		assertTrue(a.equals(b));
	}

}
