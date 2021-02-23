package com.itgorillaz.core.command;

import java.util.List;

public class Interactors {

	public static <I extends Command, C extends Context> void execute(List<Rule<I, C>> pipeline, 
		I command, 
		C context) throws RuleException {
		
		for (Rule<I, C> rule : pipeline) {
			rule.execute(command, context);
		}
		
	}
	
}
