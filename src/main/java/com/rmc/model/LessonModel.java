package com.rmc.model;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class LessonModel {
	
	public LessonModel() {
		super();
	}

	/* private String customerID; */
	private String userID;
	private String lessonID;
	private String automataID;
	private String automataName;
	private String status;
	private String showType;
	private int automataType;
	private int maxTime;
	private LocalDateTime createTime;
	private String creater;
	private LocalDateTime updateTime;
	private String updater;

	public String getuserID() {
		return userID;
	}

	public void setuserID(String userID) {
		this.userID = userID;
	}
	
	public String getlessonID() {
		return lessonID;
	}

	public void setlessonID(String lessonID) {
		this.lessonID = lessonID;
	}
	
	public String getAutomataID() {
		return automataID;
	}

	public void setAutomataID(String automataID) {
		this.automataID = automataID;
	}
    
    public String getLessonName() {
    	return automataName;
    }
    
    public void setLessonName(String automataName) {
    	this.automataName = automataName;
    }
    
    public int getLessonType() {
		return automataType;
	}

	public void setLessonType(int automataType) {
		this.automataType = automataType;
		System.out.println("type:" + automataType);
	}

	
	public String getComent(int automataType) {
		String showType = null;
		if (automataType == 1) {
			showType = "选修";
		} else if (automataType == 2) {
			showType = "必修";
		}
    	
		return showType;
	}	
	
	
	public String getShowType() {
	   	System.out.println("type:" + showType);
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}
    
    public String getLessonStatus() {
		return status;
	}

	public void setLessonStatus(String status) {
		this.status = status;
	}			
		
	public int getLessonDeadline() {
		return maxTime;
	}

	public void setLessonDeadline(int maxTime) {
		this.maxTime = maxTime;
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
	
	/*
	 * public String getCustomerID() { return customerID; }
	 * 
	 * public void setCustomerID(String customerID) { this.customerID = customerID;
	 * }
	 */


} 
