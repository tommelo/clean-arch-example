package com.itgorillaz.core.command.email.send;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.itgorillaz.core.command.Command;
import com.itgorillaz.core.command.Guard;

public class SendEmailCommand implements Command {

    private String requestId;
    private String correlationId;
    private String clientId;
    private boolean failOnSuppressedEmailRecipient;
    private boolean failOnSmtpCheck;
    private String from;
    private List<String> to;
    private List<String> cc;
    private List<String> bcc;
    private List<String> replyTo;
    private String subject;
    private String html;
    private String text;
    private List<SendEmailAttachment> attachments;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public boolean isFailOnSuppressedEmailRecipient() {
        return failOnSuppressedEmailRecipient;
    }

    public void setFailOnSuppressedEmailRecipient(boolean failOnSuppressedEmailRecipient) {
        this.failOnSuppressedEmailRecipient = failOnSuppressedEmailRecipient;
    }

    public boolean isFailOnSmtpCheck() {
        return failOnSmtpCheck;
    }

    public void setFailOnSmtpCheck(boolean failOnSmtpCheck) {
        this.failOnSmtpCheck = failOnSmtpCheck;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
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

    public List<String> getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(List<String> replyTo) {
        this.replyTo = replyTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<SendEmailAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<SendEmailAttachment> attachments) {
        this.attachments = attachments;
    }

    @Override
    public Optional<Set<ConstraintViolation<Object>>> validate() {
        return Guard.constraints(this);
    }

    public class SendEmailAttachment {
        
        private String dir;
        private String filename;
        private String attachAsFileName;

        public String getDir() {
            return dir;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getAttachAsFileName() {
            return attachAsFileName;
        }

        public void setAttachAsFileName(String attachAsFileName) {
            this.attachAsFileName = attachAsFileName;
        }

    }

}
