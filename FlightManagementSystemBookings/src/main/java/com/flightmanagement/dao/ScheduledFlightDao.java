package com.flightmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightmanagement.dto.ScheduledFlight;

public interface ScheduledFlightDao extends JpaRepository<ScheduledFlight, Integer> {

}
