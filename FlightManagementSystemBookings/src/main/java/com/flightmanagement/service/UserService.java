package com.flightmanagement.service;

import java.util.Optional;

import com.flightmanagement.dto.User;

public interface UserService {
	public Optional<User> getUser(long userId);

}
