package com.itgorillaz.core.command.email.send;

import java.util.List;

import com.itgorillaz.core.command.Context;
import com.itgorillaz.core.model.Email.EmailAttachment;
import com.itgorillaz.core.model.EmailRequest;

public class SendEmailContext implements Context {

    private String emailGatewayMessageId;
    private List<EmailAttachment> attachments;
    private List<String> emailsFailedOnSmtpCheck;
    private List<String> suppressedEmailRecipients;
    private EmailRequest emailRequest;
    private List<String> to;
    private List<String> cc;
    private List<String> bcc;

    public String getEmailGatewayMessageId() {
        return emailGatewayMessageId;
    }

    public void setEmailGatewayMessageId(String emailGatewayMessageId) {
        this.emailGatewayMessageId = emailGatewayMessageId;
    }

    public List<EmailAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<EmailAttachment> attachments) {
        this.attachments = attachments;
    }

    public List<String> getEmailsFailedOnSmtpCheck() {
        return emailsFailedOnSmtpCheck;
    }

    public void setEmailsFailedOnSmtpCheck(List<String> emailsFailedOnSmtpCheck) {
        this.emailsFailedOnSmtpCheck = emailsFailedOnSmtpCheck;
    }

    public List<String> getSuppressedEmailRecipients() {
        return suppressedEmailRecipients;
    }

    public void setSuppressedEmailRecipients(List<String> suppressedEmailRecipients) {
        this.suppressedEmailRecipients = suppressedEmailRecipients;
    }

    public EmailRequest getEmailRequest() {
        return emailRequest;
    }

    public void setEmailRequest(EmailRequest emailRequest) {
        this.emailRequest = emailRequest;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

}
