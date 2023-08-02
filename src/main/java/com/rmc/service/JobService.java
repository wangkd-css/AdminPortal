package com.rmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.dao.JobDao;
import com.rmc.model.JobModel;


@Service
public class JobService {
	
	@Autowired
	JobDao jobdao;


	public int addJob(JobModel job) {
		return jobdao.addJob(job);
	}
	
	public List<JobModel> getJobList(){
		return jobdao.getJobList();
	}

	public int deleteJob(String id) {
		return jobdao.deleteJob(id);
	}
	
	public List<JobModel> getJob(String jobID){
		return jobdao.getJob(jobID);
	}
	
	public int updateJob(JobModel job) {
		return jobdao.updateJob(job);
	}
}
