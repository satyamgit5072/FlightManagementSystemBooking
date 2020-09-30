package com.flightmanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightmanagement.dao.UserDao;
import com.flightmanagement.dto.User;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public Optional<User> getUser(long userId) {
		return userDao.findById(userId);
	}

}
