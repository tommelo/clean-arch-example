package com.itgorillaz.example.usecase.user;

import com.itgorillaz.example.model.User;
import com.itgorillaz.example.usecase.UseCaseContext;

public class CreateUserContext implements UseCaseContext {

	private String anythingFromOtherRuleHere;
	private User anyOtherResultHere;
	private User finalResult;
	
	public User getFinalResult() {
		return finalResult;
	}

	public void setFinalResult(User finalResult) {
		this.finalResult = finalResult;
	}

	public String getAnythingFromOtherRuleHere() {
		return anythingFromOtherRuleHere;
	}
	
	public void setAnythingFromOtherRuleHere(String anythingFromDbHere) {
		this.anythingFromOtherRuleHere = anythingFromDbHere;
	}

	public User getAnyOtherResultHere() {
		return anyOtherResultHere;
	}

	public void setAnyOtherResultHere(User anyOtherResultHere) {
		this.anyOtherResultHere = anyOtherResultHere;
	}
	
}
