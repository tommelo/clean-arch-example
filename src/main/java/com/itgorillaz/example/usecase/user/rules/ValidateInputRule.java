package com.itgorillaz.example.usecase.user.rules;

import java.util.Optional;

import com.itgorillaz.example.usecase.UseCaseRule;
import com.itgorillaz.example.usecase.UseCaseRuleException;
import com.itgorillaz.example.usecase.user.CreateUserContext;
import com.itgorillaz.example.usecase.user.CreateUserInput;

import am.ik.yavi.core.ConstraintViolations;

public class ValidateInputRule implements UseCaseRule<CreateUserInput, CreateUserContext> {

	@Override
	public void execute(CreateUserInput input, CreateUserContext context) throws UseCaseRuleException {
		Optional<ConstraintViolations> optional = input.validate();
		if (optional.isPresent()) {
			// add details to the exception
			// like passing the ConstraintViolations
			throw new UseCaseRuleException();
		}
		
		context.setAnythingFromOtherRuleHere("anything");
	}

}
