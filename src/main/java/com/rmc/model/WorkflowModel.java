package com.rmc.model;


public class WorkflowModel {

	public WorkflowModel() {
		super();
	}

	private String jobID;
	
	private String Status;
	
	private String NextJob;
	
	private String WaitTime;

	public String getJobID() {
		return jobID;
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	public String getNextJob() {
		return NextJob;
	}
	
	public void setNextJob(String nextJob) {
		NextJob = nextJob;
	}

	public String getWaitTime() {
		return WaitTime;
	}

	public void setWaitTime(String waitTime) {
		WaitTime = waitTime;
	}

}
