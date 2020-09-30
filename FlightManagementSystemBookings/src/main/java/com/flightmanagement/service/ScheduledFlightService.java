package com.flightmanagement.service;

import java.util.List;
import java.util.Optional;

import com.flightmanagement.dto.ScheduledFlight;


public interface ScheduledFlightService {
	
	public List<ScheduledFlight> getAllFlightSchedules();
	
	public Optional<ScheduledFlight> getFlightSchedule(int scheduleId);

}
