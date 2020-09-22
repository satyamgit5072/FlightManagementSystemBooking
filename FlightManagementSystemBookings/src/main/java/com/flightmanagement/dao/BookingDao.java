package com.flightmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightmanagement.dto.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Long>{

}
