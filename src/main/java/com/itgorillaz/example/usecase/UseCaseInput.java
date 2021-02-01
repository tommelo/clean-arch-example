package com.itgorillaz.example.usecase;

import java.util.Optional;

import am.ik.yavi.core.ConstraintViolations;

public interface UseCaseInput {

	Optional<ConstraintViolations> validate();
	
}
