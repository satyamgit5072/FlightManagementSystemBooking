package com.flightmanagement.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="booking_table")
public class Booking {
	
	@Id
    @Column(name="bookingId")
	@NotNull(message="passenger Id should not be empty")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingIdSequence")
    @SequenceGenerator(name = "bookingIdSequence", sequenceName = "booking_details_sequence_name", allocationSize=1)
	private long bookingId;
	
	@NotNull(message="user deatils must be entered")
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@NotNull(message="you must select the scheduledFlight")
	@OneToOne
    @JoinColumn(name="sched_id")
    private ScheduledFlight scheduledFlight;
	
	@NotNull(message="passengers details must be entered")
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="booking_id")
	private List<@Valid Passenger> passengerList;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
	private Date bookingDate;

	public Booking() {
		super();
	}

	public Booking(User user,
			ScheduledFlight scheduledFlight, List<Passenger> passengerList, Date bookingDate) {
		super();
		this.user = user;
		this.scheduledFlight = scheduledFlight;
		this.passengerList = passengerList;
		this.bookingDate = bookingDate;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ScheduledFlight getScheduledFlight() {
		return scheduledFlight;
	}

	public void setScheduledFlight(ScheduledFlight scheduledFlight) {
		this.scheduledFlight = scheduledFlight;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

}
