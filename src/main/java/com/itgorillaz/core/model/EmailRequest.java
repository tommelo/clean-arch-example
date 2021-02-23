package com.itgorillaz.core.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class EmailRequest {

    private String id;
    private String requestId;
    private String correlationId;
    private String clientId;
    private EmailStatus status;
    private EmailRequestStatusCode statusCode;
    private BigInteger ttl;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public BigInteger getTtl() {
        return ttl;
    }

    public void setTtl(BigInteger ttl) {
        this.ttl = ttl;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
