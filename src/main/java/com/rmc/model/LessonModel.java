package com.rmc.model;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class LessonModel {
	
	public LessonModel() {
		super();
	}

	/* private String customerID; */
	private String lessonID;
	private String lessonName;
	private String lessonStatus;
	private String lessonType;
	private LocalDate lessonDeadline;
	private LocalDateTime createTime;
	private String creater;
	private LocalDateTime updateTime;
	private String updater;



	public String getLessonID() {
		return lessonID;
	}

	public void setLessonID(String lessonID) {
		this.lessonID = lessonID;
	}
    
    public String getLessonName() {
    	return lessonName;
    }
    
    public void setLessonName(String lessonName) {
    	this.lessonName = lessonName;
    }
    
    public String getLessonType() {
		return lessonType;
	}

	public void setLessonType(String lessonType) {
		this.lessonType = lessonType;
	}
    
    public String getLessonStatus() {
		return lessonStatus;
	}

	public void setLessonStatus(String lessonStatus) {
		this.lessonStatus = lessonStatus;
	}
	
	public LocalDate getLessonDeadline() {
		return lessonDeadline;
	}

	public void setLessonDeadline(LocalDate lessonDeadline) {
		this.lessonDeadline = lessonDeadline;
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
