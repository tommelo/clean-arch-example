package com.itgorillaz.example.usecase.user;

import java.util.Optional;

import com.itgorillaz.example.usecase.UseCaseInput;

import am.ik.yavi.builder.ValidatorBuilder;
import am.ik.yavi.core.ConstraintViolations;
import am.ik.yavi.core.Validator;

public class CreateUserInput implements UseCaseInput {

	private static final Validator<CreateUserInput> VALIDATOR = buildValidator();
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Optional<ConstraintViolations> validate() {
		return Optional.ofNullable(VALIDATOR.validate(this));
	}

	private static Validator<CreateUserInput> buildValidator() {
		return ValidatorBuilder
			.of(CreateUserInput.class)
			.constraint(CreateUserInput::getName, "name", c -> c.notEmpty())
			.build();
	}
}
