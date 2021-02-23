package com.itgorillaz.core.command;

public class RuleException extends Exception {

    private String statusCode;
    private Object reason;

    public RuleException(String statusCode, Object reason) {
        this.statusCode = statusCode;
        this.reason = reason;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public Object getReason() {
        return reason;
    }

}
