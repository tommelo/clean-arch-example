package com.itgorillaz.core.command.email.send.rule;

import com.itgorillaz.core.command.Rule;
import com.itgorillaz.core.command.RuleException;
import com.itgorillaz.core.command.email.send.SendEmailCommand;
import com.itgorillaz.core.command.email.send.SendEmailContext;
import com.itgorillaz.core.model.ApplicationClient;
import com.itgorillaz.core.model.EmailRequestStatusCode;
import com.itgorillaz.core.service.AuthService;

public class ValidateQuotaRule implements Rule<SendEmailCommand, SendEmailContext> {

	private AuthService authService;
	
	public ValidateQuotaRule(AuthService authService) {
		this.authService = authService;
	}
	
	@Override
	public void execute(SendEmailCommand command, SendEmailContext context) throws RuleException {
		ApplicationClient applicationClient = this.authService
			.findApplicationClientById(command.getClientId())
			.orElseThrow(() -> new RuleException(EmailRequestStatusCode.APPLICATION_CLIENT_NOT_FOUND.toString(), command.getClientId()));
		
		if (!applicationClient.isActive()) {
			throw new RuleException(EmailRequestStatusCode.APPLICATION_CLIENT_NOT_ENABLED.toString(), applicationClient);
		}
		
		if (applicationClient.getDailyRequestsCount().compareTo(applicationClient.getDailyQuota()) == 1) {
			throw new RuleException(EmailRequestStatusCode.APPLICATION_DAILY_QUOTA_EXCEEDED.toString(), applicationClient);
		}
	}

}
