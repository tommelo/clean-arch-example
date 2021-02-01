package com.itgorillaz.example.usecase.user.rules;

import java.util.Optional;

import com.itgorillaz.example.model.User;
import com.itgorillaz.example.service.UserService;
import com.itgorillaz.example.usecase.UseCaseRule;
import com.itgorillaz.example.usecase.UseCaseRuleException;
import com.itgorillaz.example.usecase.user.CreateUserContext;
import com.itgorillaz.example.usecase.user.CreateUserInput;

public class AnyOtherRule implements UseCaseRule<CreateUserInput, CreateUserContext> {

	private UserService service;
	
	public AnyOtherRule(UserService service) {
		this.service = service;
	}
	
	@Override
	public void execute(CreateUserInput input, CreateUserContext context) throws UseCaseRuleException {
		// get any result from the context
		// and use it to apply any rule
		context.getAnythingFromOtherRuleHere();
		
		Optional<User> optional = service.findUserByName(input.getName());
		if (optional.isPresent()) {
			// pass another detail here
			throw new UseCaseRuleException();
		}
		
		context.setAnyOtherResultHere(new User());
	}

}
