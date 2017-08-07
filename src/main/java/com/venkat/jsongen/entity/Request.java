package com.venkat.jsongen.entity;

/**
 * Created by venkatram.veerareddy on 8/7/2017.
 */

public class Request {

    private String empRequestID;
    private String requestDate;
    private String empProviderID;
    private String empProviderName;
    private String empProductID;
    private String empProductName;
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
    public String getEmpProviderID() {
        return empProviderID;
    }
    public void setEmpProviderID(String empProviderID) {
        this.empProviderID = empProviderID;
    }
    public String getEmpProviderName() {
        return empProviderName;
    }
    public void setEmpProviderName(String empProviderName) {
        this.empProviderName = empProviderName;
    }
    public String getEmpProductID() {
        return empProductID;
    }
    public void setEmpProductID(String empProductID) {
        this.empProductID = empProductID;
    }
    public String getEmpProductName() {
        return empProductName;
    }
    public void setEmpProductName(String empProductName) {
        this.empProductName = empProductName;
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
