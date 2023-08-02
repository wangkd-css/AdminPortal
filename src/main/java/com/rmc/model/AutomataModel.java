package com.rmc.model;

import java.time.LocalDateTime;

public class AutomataModel {

	public AutomataModel() {
		super();
	}

	private String automataID;
	private String automataName;
	private int automataType;
	private String showType;
	private String businessID;
	private int maxTime;
	private LocalDateTime createTime;
	private String creater;
	private LocalDateTime updateTime;
	private String updater;

	public String getAutomataID() {
		return automataID;
	}

	public void setAutomataID(String automataID) {
		this.automataID = automataID;
	}

	public String getAutomataName() {
		return automataName;
	}

	public void setAutomataName(String automataName) {
		this.automataName = automataName;
	}

	public int getAutomataType() {
		return automataType;
	}

	public void setAutomataType(int automataType) {
		this.automataType = automataType;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getBusinessID() {
		return businessID;
	}

	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}

	public int getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(int maxTime) {
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

	public String getComent(int automataType) {
		String showType = null;
		if (automataType == 1) {
			showType = "选修";
		} else if (automataType == 2) {
			showType = "必修";
		}
		/*
		 * else if(automataType == 3) { showType = "UIPath"; } else if(automataType ==
		 * 4) { showType = "DeskTop"; }
		 */
		return showType;
	}
}
