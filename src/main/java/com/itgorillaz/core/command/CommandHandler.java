package com.itgorillaz.core.command;

public interface CommandHandler<I extends Command, O> {

	O execute(I command);
	
}
