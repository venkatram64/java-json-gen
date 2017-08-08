package com.venkat.jsongen.entity;

/**
 * Created by venkatram.veerareddy on 8/8/2017.
 */
public class CompositeRequest {

    private String empRequestID;
    private String requestDate;
    private Provider provider;

    private String empProductClassification;
    private String empProductSubClassification;
    private String empReviewType;
    private String empRequestingGroup;
    private String questionnaireUrl;
    private int priority;

    public String getEmpRequestID() {
        return empRequestID;
    }
    public void setEmpRequestID(String empRequestID) {
        this.empRequestID = empRequestID;
    }
    public String getRequestDate() {
        return requestDate;
    }
    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getEmpProductClassification() {
        return empProductClassification;
    }
    public void setEmpProductClassification(String empProductClassification) {
        this.empProductClassification = empProductClassification;
    }
    public String getEmpProductSubClassification() {
        return empProductSubClassification;
    }
    public void setEmpProductSubClassification(String empProductSubClassification) {
        this.empProductSubClassification = empProductSubClassification;
    }
    public String getEmpReviewType() {
        return empReviewType;
    }
    public void setEmpReviewType(String empReviewType) {
        this.empReviewType = empReviewType;
    }
    public String getEmpRequestingGroup() {
        return empRequestingGroup;
    }
    public void setEmpRequestingGroup(String empRequestingGroup) {
        this.empRequestingGroup = empRequestingGroup;
    }
    public String getQuestionnaireUrl() {
        return questionnaireUrl;
    }
    public void setQuestionnaireUrl(String questionnaireUrl) {
        this.questionnaireUrl = questionnaireUrl;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
}
