package com.flightmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightmanagement.dto.User;
public interface UserDao extends JpaRepository<User, Long>{

}
