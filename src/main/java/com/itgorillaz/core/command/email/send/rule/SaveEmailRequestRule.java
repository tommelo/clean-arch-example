package com.itgorillaz.core.command.email.send.rule;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.itgorillaz.core.command.Rule;
import com.itgorillaz.core.command.RuleException;
import com.itgorillaz.core.command.email.send.SendEmailCommand;
import com.itgorillaz.core.command.email.send.SendEmailContext;
import com.itgorillaz.core.model.EmailRequest;
import com.itgorillaz.core.model.EmailRequestStatusCode;
import com.itgorillaz.core.model.EmailStatus;
import com.itgorillaz.core.service.EmailService;

public class SaveEmailRequestRule implements Rule<SendEmailCommand, SendEmailContext> {

    private EmailService emailService;
    
    public SaveEmailRequestRule(EmailService emailService) {
        this.emailService = emailService;
    }
    
    @Override
    public void execute(SendEmailCommand command, SendEmailContext context) throws RuleException {
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setId(context.getEmailGatewayMessageId());
        emailRequest.setClientId(command.getClientId());
        emailRequest.setCorrelationId(command.getCorrelationId());
        emailRequest.setRequestId(command.getRequestId());
        emailRequest.setStatus(EmailStatus.DELIVERED_TO_GATEWAY);
        emailRequest.setStatusCode(EmailRequestStatusCode.OK);
        emailRequest.setTtl(BigInteger.valueOf(10000));
        emailRequest.setCreatedAt(LocalDateTime.now());
        
        emailService.registerEmailRequest(emailRequest);
        
        context.setEmailRequest(emailRequest);
    }

}
