package com.itgorillaz.example.usecase;

public interface UseCase<I extends UseCaseInput, O> {
	
	O execute(I input);

}
