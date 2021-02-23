package com.itgorillaz.core.command.email.send.rule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.itgorillaz.core.command.Rule;
import com.itgorillaz.core.command.RuleException;
import com.itgorillaz.core.command.email.send.SendEmailCommand;
import com.itgorillaz.core.command.email.send.SendEmailContext;
import com.itgorillaz.core.model.EmailRequestStatusCode;
import com.itgorillaz.core.model.SuppressedEmailRecipient;
import com.itgorillaz.core.service.EmailService;

public class ValidateSuppressedEmailRecipientsRule implements Rule<SendEmailCommand, SendEmailContext> {

	private EmailService emailService;
	
	public ValidateSuppressedEmailRecipientsRule(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@Override
	public void execute(SendEmailCommand command, SendEmailContext context) throws RuleException {
		List<String> emails = new ArrayList<>(command.getTo());
		emails.addAll(command.getCc());
		emails.addAll(command.getBcc());
		
		List<SuppressedEmailRecipient> suppressedRecipients = emailService.findSuppressedEmailRecipients(new HashSet<>(emails));
		if (command.isFailOnSuppressedEmailRecipient() && !suppressedRecipients.isEmpty()) {
			throw new RuleException(EmailRequestStatusCode.SUPPRESSED_RECIPIENT_FOUND.toString(), suppressedRecipients);
		}
		
		List<String> recipients = suppressedRecipients.stream().map(e -> e.getId()).collect(Collectors.toList());
		
		context.setSuppressedEmailRecipients(recipients);
	}

	
	
}
