package com.rmc.model;

public class JobModel {
	
	public JobModel() {
		super();
	}

	private int jobID;
	
	private int serverID;
	
	private String automataID;
	
	private int refresh;
	
	private String param;
	
	private int waitTime;
	
	private int resourceID;

	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}

	public int getServerID() {
		return serverID;
	}

	public void setServerID(int serverID) {
		this.serverID = serverID;
	}

	public String getAutomataID() {
		return automataID;
	}

	public void setAutomataID(String automataID) {
		this.automataID = automataID;
	}

	public int getRefresh() {
		return refresh;
	}

	public void setRefresh(int refresh) {
		this.refresh = refresh;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	public int getResourceID() {
		return resourceID;
	}

	public void setResourceID(int resourceID) {
		this.resourceID = resourceID;
	}
	
}
