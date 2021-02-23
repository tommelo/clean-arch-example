package com.itgorillaz.core.command;

import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;

public interface Command {

	Optional<Set<ConstraintViolation<Object>>> validate();
	
}
