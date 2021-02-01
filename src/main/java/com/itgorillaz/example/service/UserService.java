package com.itgorillaz.example.service;

import java.util.Optional;

import com.itgorillaz.example.model.User;

public interface UserService {

	Optional<User> findUserByName(String name);
	
}
