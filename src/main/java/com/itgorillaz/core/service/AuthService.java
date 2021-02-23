package com.itgorillaz.core.service;

import java.util.Optional;

import com.itgorillaz.core.model.ApplicationClient;

public interface AuthService {

	Optional<ApplicationClient> findApplicationClientById(String id);
	
}
