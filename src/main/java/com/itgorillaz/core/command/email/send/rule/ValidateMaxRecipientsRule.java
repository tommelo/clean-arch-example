package com.itgorillaz.core.command.email.send.rule;

import java.util.ArrayList;
import java.util.List;

import com.itgorillaz.core.command.Rule;
import com.itgorillaz.core.command.RuleException;
import com.itgorillaz.core.command.email.send.SendEmailCommand;
import com.itgorillaz.core.command.email.send.SendEmailContext;
import com.itgorillaz.core.model.EmailRequestStatusCode;

public class ValidateMaxRecipientsRule implements Rule<SendEmailCommand, SendEmailContext> {

	private final int MAX_RECIPIENTS_ALLOWED = 50;
	
	@Override
	public void execute(SendEmailCommand command, SendEmailContext context) throws RuleException {
		List<String> recipients = new ArrayList<>(context.getTo());
		recipients.addAll(context.getCc());
		recipients.addAll(context.getBcc());

		if (recipients.size() > MAX_RECIPIENTS_ALLOWED) {
			throw new RuleException(EmailRequestStatusCode.MAX_RECIPIENTS_EXCEEDED.toString(), recipients);
		}
	}

}
