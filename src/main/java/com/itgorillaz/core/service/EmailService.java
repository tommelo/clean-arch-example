package com.itgorillaz.core.service;

import java.util.List;
import java.util.Set;

import com.itgorillaz.core.model.Email;
import com.itgorillaz.core.model.EmailRequest;
import com.itgorillaz.core.model.SuppressedEmailRecipient;

public interface EmailService {

    List<SmtpPingResult> ping(Set<String> emails);
    
    SendEmailGatewayResult sendEmail(Email email);
    
    List<SuppressedEmailRecipient> findSuppressedEmailRecipients(Set<String> emails);
    
    List<String> listAllSenderIdentities();
    
    void registerEmailRequest(EmailRequest emailRequest);
    
}
