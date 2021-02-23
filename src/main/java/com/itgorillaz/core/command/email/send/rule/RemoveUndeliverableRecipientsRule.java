package com.itgorillaz.core.command.email.send.rule;

import java.util.ArrayList;
import java.util.List;

import com.itgorillaz.core.command.Rule;
import com.itgorillaz.core.command.RuleException;
import com.itgorillaz.core.command.email.send.SendEmailCommand;
import com.itgorillaz.core.command.email.send.SendEmailContext;
import com.itgorillaz.core.model.EmailRequestStatusCode;

public class RemoveUndeliverableRecipientsRule implements Rule<SendEmailCommand, SendEmailContext> {

    @Override
    public void execute(SendEmailCommand command, SendEmailContext context) throws RuleException {
        List<String> undeliverableEmailRecipients = new ArrayList<>(context.getSuppressedEmailRecipients());
        undeliverableEmailRecipients.addAll(context.getEmailsFailedOnSmtpCheck());
        
        List<String> to = new ArrayList<>(command.getTo());
        to.removeAll(undeliverableEmailRecipients);
        
        List<String> cc = new ArrayList<>(command.getCc());
        cc.removeAll(undeliverableEmailRecipients);
        
        List<String> bcc = new ArrayList<>(command.getBcc());
        bcc.removeAll(undeliverableEmailRecipients);
        
        if (to.isEmpty()) {
            throw new RuleException(EmailRequestStatusCode.MAIN_RECIPIENT_IS_UNDELIVERABLE.toString(), command.getTo());
        }
        
        context.setTo(to);
        context.setCc(cc);
        context.setBcc(bcc);
    }
    
}
