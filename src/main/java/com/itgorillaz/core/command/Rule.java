package com.itgorillaz.core.command;

public interface Rule<I extends Command, C extends Context> {

	void execute(I command, C context) throws RuleException;
	
}
