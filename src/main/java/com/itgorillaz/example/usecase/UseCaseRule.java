package com.itgorillaz.example.usecase;

public interface UseCaseRule<I extends UseCaseInput, C extends UseCaseContext> {

	void execute(I request, C context) throws UseCaseRuleException;
	
}
