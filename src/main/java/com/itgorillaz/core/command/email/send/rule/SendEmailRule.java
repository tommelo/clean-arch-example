package com.itgorillaz.core.command.email.send.rule;

import com.itgorillaz.core.command.Rule;
import com.itgorillaz.core.command.RuleException;
import com.itgorillaz.core.command.email.send.SendEmailCommand;
import com.itgorillaz.core.command.email.send.SendEmailContext;
import com.itgorillaz.core.model.Email;
import com.itgorillaz.core.service.EmailService;
import com.itgorillaz.core.service.SendEmailGatewayResult;

public class SendEmailRule implements Rule<SendEmailCommand, SendEmailContext> {

	private EmailService emailService;
	
	public SendEmailRule(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@Override
	public void execute(SendEmailCommand command, SendEmailContext context) throws RuleException {
		Email email = new Email();
		email.setFrom(command.getFrom());
		email.setSender(command.getFrom());
		email.setReplyTo(command.getReplyTo());
		email.setTo(context.getTo());
		email.setCc(context.getCc());
		email.setBcc(context.getBcc());
		email.setSubject(command.getSubject());
		email.setHtml(command.getHtml());
		email.setAttachments(context.getAttachments());
		
		SendEmailGatewayResult result = emailService.sendEmail(email);
		
		context.setEmailGatewayMessageId(result.getMessageId());
	}

}
