package com.itgorillaz.core.model;

public class Bounce extends SuppressedEmailRecipient {

    private String action;
    private String status;
    private String diagnosticCode;
    private BounceType bounceType;

    public Bounce() {
        super(SuppressingType.BOUNCE);
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDiagnosticCode() {
        return diagnosticCode;
    }

    public void setDiagnosticCode(String diagnosticCode) {
        this.diagnosticCode = diagnosticCode;
    }

    public BounceType getBounceType() {
        return bounceType;
    }

    public void setBounceType(BounceType bounceType) {
        this.bounceType = bounceType;
    }

}
