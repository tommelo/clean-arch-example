package com.itgorillaz.example.usecase.user;

import java.util.Arrays;
import java.util.List;

import com.itgorillaz.example.service.UserService;
import com.itgorillaz.example.usecase.Interactors;
import com.itgorillaz.example.usecase.UseCase;
import com.itgorillaz.example.usecase.UseCaseRule;
import com.itgorillaz.example.usecase.UseCaseRuleException;
import com.itgorillaz.example.usecase.user.rules.AnyOtherRule;
import com.itgorillaz.example.usecase.user.rules.ValidateInputRule;

// small and clean use case bra
public class CreateUserUseCase implements UseCase<CreateUserInput, CreateUserResult> {

	private List<UseCaseRule<CreateUserInput, CreateUserContext>> rules;
	
	public CreateUserUseCase(UserService service) {
		// here it is your pipeline of use case rules
		this.rules = Arrays.asList(
			new ValidateInputRule(),
			new AnyOtherRule(service));
	}
	
	@Override
	public CreateUserResult execute(CreateUserInput input) {	
		CreateUserContext context = new CreateUserContext();
		
		try {
		
			// you can even return something from the pipeline
			// like result = Interactors.execute(rules, input, context)
			Interactors.execute(this.rules, input, context);
			
			// return the success with details
			// something like that and pass the value and pass to the createuserresult
			context.getFinalResult();
			
			return new CreateUserResult();
			
		} catch (UseCaseRuleException e) {
			// add the error details here
			// get the damn thing from the exception
			return new CreateUserResult();
		}
	}

}
