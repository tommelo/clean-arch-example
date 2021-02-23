package com.itgorillaz.core.command.email.send.rule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.itgorillaz.core.command.Rule;
import com.itgorillaz.core.command.RuleException;
import com.itgorillaz.core.command.email.send.SendEmailCommand;
import com.itgorillaz.core.command.email.send.SendEmailContext;
import com.itgorillaz.core.model.EmailRequestStatusCode;
import com.itgorillaz.core.service.EmailService;
import com.itgorillaz.core.service.SmtpPingResult;

public class ValidateEmailExistenceRule implements Rule<SendEmailCommand, SendEmailContext> {

	private EmailService emailService;
	
	public ValidateEmailExistenceRule(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@Override
	public void execute(SendEmailCommand command, SendEmailContext context) throws RuleException {
		List<String> emailsFailedOnSmtpCheck = new ArrayList<>();
		
		List<String> recipients = new ArrayList<>(command.getTo());
		recipients.addAll(command.getCc());
		recipients.addAll(command.getBcc());
		
		Set<String> emails = new HashSet<>(recipients);
		
		if (command.isFailOnSmtpCheck()) {
			List<SmtpPingResult> results = this.emailService.ping(emails);
			List<String> failedChecks = results
				.stream()
				.filter(r -> !r.isSuccess())
				.map(r -> r.getEmail())
				.collect(Collectors.toList());;
			
			if (!failedChecks.isEmpty()) {
				throw new RuleException(EmailRequestStatusCode.FAILED_ON_SMTP_CHECK.toString(), failedChecks);
			}
			
			emailsFailedOnSmtpCheck.addAll(failedChecks);
		}
		
		context.setEmailsFailedOnSmtpCheck(emailsFailedOnSmtpCheck);
	}

}
