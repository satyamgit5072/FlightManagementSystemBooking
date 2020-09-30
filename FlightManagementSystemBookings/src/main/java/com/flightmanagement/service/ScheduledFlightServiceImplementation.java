package com.flightmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.flightmanagement.dao.ScheduledFlightDao;
import com.flightmanagement.dto.ScheduledFlight;

@Service
public class ScheduledFlightServiceImplementation implements ScheduledFlightService {
	
	@Autowired 
	ScheduledFlightDao scheduledFlightDao;
	

	@Override
	public List<ScheduledFlight> getAllFlightSchedules() {
		return scheduledFlightDao.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}


	@Override
	public Optional<ScheduledFlight> getFlightSchedule(int scheduleId) {
		return scheduledFlightDao.findById(scheduleId);
	}

}
