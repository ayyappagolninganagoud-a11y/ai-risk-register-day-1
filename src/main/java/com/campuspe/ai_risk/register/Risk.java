package com.campuspe.ai_risk.register;

import java.io.Serializable;

public class Risk implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String riskName;
    private String description;
    private String severity;

    public Risk() {
    }

    public Risk(Long id, String riskName, String description, String severity) {
        this.id = id;
        this.riskName = riskName;
        this.description = description;
        this.severity = severity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}