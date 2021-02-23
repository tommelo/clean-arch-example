package com.itgorillaz.core.command.email.send.rule;

import java.util.List;

import com.itgorillaz.core.command.Rule;
import com.itgorillaz.core.command.RuleException;
import com.itgorillaz.core.command.email.send.SendEmailCommand;
import com.itgorillaz.core.command.email.send.SendEmailContext;
import com.itgorillaz.core.model.EmailRequestStatusCode;
import com.itgorillaz.core.service.EmailService;

public class ValidateSenderIdentityRule implements Rule<SendEmailCommand, SendEmailContext> {

	private EmailService emailService;
	
	public ValidateSenderIdentityRule(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@Override
	public void execute(SendEmailCommand command, SendEmailContext context) throws RuleException {
		List<String> identities = this.emailService.listAllSenderIdentities();
		if (!identities.contains(command.getFrom())) {
			throw new RuleException(EmailRequestStatusCode.SENDER_IDENTITY_NOT_VERIFIED.toString(), command.getFrom());
		}
	}

}
