package com.itgorillaz.core.model;

public class Complaint extends SuppressedEmailRecipient {

    private String reason;

    public Complaint() {
        super(SuppressingType.COMPLAINT);
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
