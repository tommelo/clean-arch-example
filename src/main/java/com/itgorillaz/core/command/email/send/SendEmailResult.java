package com.itgorillaz.core.command.email.send;

import com.itgorillaz.core.model.EmailRequestStatusCode;
import com.itgorillaz.core.model.EmailStatus;

public class SendEmailResult {

    private String requestId;
    private String correlationId;
    private String clientId;
    private EmailStatus status;
    private EmailRequestStatusCode statusCode;
    private Object payload;

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

    public EmailStatus getStatus() {
        return status;
    }

    public void setStatus(EmailStatus status) {
        this.status = status;
    }

    public EmailRequestStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(EmailRequestStatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

}
