package com.insurance.Insurance.model;

import java.util.Date;

public class InsurancePolicy {
    private int id;
    private int customerId;
    private Date creationDate;
    private double sumAssured;
    private Date applicableDate;
    private int insurancePackageId;
    private double yearlyPremiumAmount;
    private Date expiryDate;
    private int agentId;
    private String status;
    private int count;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public double getSumAssured() {
		return sumAssured;
	}
	public void setSumAssured(double sumAssured) {
		this.sumAssured = sumAssured;
	}
	public Date getApplicableDate() {
		return applicableDate;
	}
	public void setApplicableDate(Date applicableDate) {
		this.applicableDate = applicableDate;
	}
	public int getInsurancePackageId() {
		return insurancePackageId;
	}
	public void setInsurancePackageId(int insurancePackageId) {
		this.insurancePackageId = insurancePackageId;
	}
	public double getYearlyPremiumAmount() {
		return yearlyPremiumAmount;
	}
	public void setYearlyPremiumAmount(double yearlyPremiumAmount) {
		this.yearlyPremiumAmount = yearlyPremiumAmount;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "InsurancePolicy [id=" + id + ", customerId=" + customerId + ", creationDate=" + creationDate
				+ ", sumAssured=" + sumAssured + ", applicableDate=" + applicableDate + ", insurancePackageId="
				+ insurancePackageId + ", yearlyPremiumAmount=" + yearlyPremiumAmount + ", expiryDate=" + expiryDate
				+ ", agentId=" + agentId + ", status=" + status + ", count=" + count + "]";
	}
	public InsurancePolicy(int id, int customerId, Date creationDate, double sumAssured, Date applicableDate,
			int insurancePackageId, double yearlyPremiumAmount, Date expiryDate, int agentId, String status,
			int count) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.creationDate = creationDate;
		this.sumAssured = sumAssured;
		this.applicableDate = applicableDate;
		this.insurancePackageId = insurancePackageId;
		this.yearlyPremiumAmount = yearlyPremiumAmount;
		this.expiryDate = expiryDate;
		this.agentId = agentId;
		this.status = status;
		this.count = count;
	}
	public InsurancePolicy() {
		super();
	}
    
}
