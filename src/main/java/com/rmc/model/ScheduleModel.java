package com.rmc.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ScheduleModel {
	
	public ScheduleModel() {
		super();
	}

	private int runRate;
	
	private int timeMeasurement;
	
	private String timeZone;
	
	//@JsonFormat(pattern = "MM/dd/yyyy hh:mm a")
	private LocalDateTime startTime;
	
	//@JsonFormat(pattern = "MM/dd/yyyy hh:mm a")
	private LocalDateTime endTime;
	
	private int refresh;
	
	private LocalDateTime createTime;
	
	private String creater;
	
	private LocalDateTime updateTime;
	
	private String updater;
	
	private int inActiveFlg;
	
	private int jobID;

	private String showType;
	
	public int getRunRate() {
		return runRate;
	}

	public void setRunRate(int runRate) {
		this.runRate = runRate;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public int getTimeMeasurement() {
		return timeMeasurement;
	}

	public void setTimeMeasurement(int timeMeasurement) {
		this.timeMeasurement = timeMeasurement;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public int getRefresh() {
		return refresh;
	}

	public void setRefresh(int refresh) {
		this.refresh = refresh;
	}


	public int getInActiveFlg() {
		return inActiveFlg;
	}

	public void setInActiveFlg(int inActiveFlg) {
		this.inActiveFlg = inActiveFlg;
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

	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	
	public String getComent(int runType) {
		String showType = null;
		if(runType == 0) {
			showType = "每分";
		}
		if(runType == 1) {
			showType = "毎時間";
		}
		else if(runType == 2) {
			showType = "毎日";
		}
		else if(runType == 3) {
			showType = "毎週";
		}
		else if(runType == 4) {
			showType = "毎月";
		}
		if(runType == 5) {
			showType = "毎年";
		}
		if(runType == 6) {
			showType = "一次";
		}
		return showType;
	}
}
