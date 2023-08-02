package com.rmc.model;

import java.time.LocalDateTime;

public class BusinessModel {
	
	public BusinessModel() {
		super();
	}

	private String customerID;
	private String businessID;
	private String businessName;
	private int businessType;
	private LocalDateTime createTime;
	private String creater;
	private LocalDateTime updateTime;
	private String updater;


    
    public String getBusinessName() {
    	return businessName;
    }
    
    public void setBusinessName(String businessName) {
    	this.businessName = businessName;
    }
    
    public int getBusinessType() {
		return businessType;
	}

	public void setBusinessType(int businessType) {
		this.businessType = businessType;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getBusinessID() {
		return businessID;
	}

	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}


} 
