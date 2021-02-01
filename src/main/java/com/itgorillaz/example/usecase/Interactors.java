package com.itgorillaz.example.usecase;

import java.util.List;

public class Interactors {

	public static <I extends UseCaseInput, C extends UseCaseContext> void execute(
			List<UseCaseRule<I, C>> pipeline,
			I input,
			C context) throws UseCaseRuleException {
		
		for (UseCaseRule<I, C> rule : pipeline) {
			rule.execute(input, context);
		}
		
	}
	
}

