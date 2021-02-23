package com.itgorillaz.core.command.email.send;

import java.util.Arrays;
import java.util.List;

import com.itgorillaz.core.command.CommandHandler;
import com.itgorillaz.core.command.Interactors;
import com.itgorillaz.core.command.Rule;
import com.itgorillaz.core.command.RuleException;
import com.itgorillaz.core.command.email.send.rule.LoadAttachmentsRule;
import com.itgorillaz.core.command.email.send.rule.RemoveUndeliverableRecipientsRule;
import com.itgorillaz.core.command.email.send.rule.SaveEmailRequestRule;
import com.itgorillaz.core.command.email.send.rule.SendEmailRule;
import com.itgorillaz.core.command.email.send.rule.ValidateCommandRule;
import com.itgorillaz.core.command.email.send.rule.ValidateMaxRecipientsRule;
import com.itgorillaz.core.command.email.send.rule.ValidateQuotaRule;
import com.itgorillaz.core.command.email.send.rule.ValidateSenderIdentityRule;
import com.itgorillaz.core.command.email.send.rule.ValidateSuppressedEmailRecipientsRule;
import com.itgorillaz.core.model.EmailRequestStatus;
import com.itgorillaz.core.model.EmailRequestStatusCode;
import com.itgorillaz.core.model.EmailStatus;
import com.itgorillaz.core.service.AuthService;
import com.itgorillaz.core.service.EmailService;
import com.itgorillaz.core.service.FileStorageService;
import com.itgorillaz.core.service.NotificationEvent;
import com.itgorillaz.core.service.NotificationService;

public class SendEmailCommandHandler implements CommandHandler<SendEmailCommand, SendEmailResult> {

    private NotificationService notificationService;
    private List<Rule<SendEmailCommand, SendEmailContext>> pipeline;
    
    public SendEmailCommandHandler(AuthService authService, 
        EmailService emailService, 
        FileStorageService fileStorageService, 
        NotificationService notificationService) {
        
        this.notificationService = notificationService;
        this.pipeline = Arrays.asList(
            new ValidateCommandRule(),
            new ValidateQuotaRule(authService),
            new ValidateSuppressedEmailRecipientsRule(emailService),
            new RemoveUndeliverableRecipientsRule(),
            new ValidateMaxRecipientsRule(),
            new ValidateSenderIdentityRule(emailService),
            new LoadAttachmentsRule(fileStorageService),
            new SendEmailRule(emailService),
            new SaveEmailRequestRule(emailService)
        );
    }
    
    @Override
    public SendEmailResult execute(SendEmailCommand command) {
        SendEmailResult result = new SendEmailResult();
        result.setClientId(command.getClientId());
        result.setCorrelationId(command.getCorrelationId());
        result.setRequestId(command.getRequestId());
        
        SendEmailContext context = new SendEmailContext();
        
        try {
            
            Interactors.execute(this.pipeline, command, context);
            
            result.setStatus(EmailStatus.DELIVERED_TO_GATEWAY);
            result.setStatusCode(EmailRequestStatusCode.OK);
            
        } catch (RuleException e) {
            result.setStatus(EmailStatus.NOT_DELIVERED);
            result.setStatusCode(EmailRequestStatusCode.valueOf(e.getStatusCode()));
            
        } catch (Exception e) {
            result.setStatus(EmailStatus.NOT_DELIVERED);
            result.setStatusCode(EmailRequestStatusCode.UNEXPECTED_ERROR);
        }
        
        notificationService.dispatch(new NotificationEvent(EmailRequestStatus.SEND_EMAIL_REQUEST_COMPLETED.toString(), result));
        
        return result;
    }

}
