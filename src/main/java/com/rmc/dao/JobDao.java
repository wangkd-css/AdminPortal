package com.rmc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.rmc.model.JobModel;


@Mapper
//@Component
public interface JobDao {
	

	public int addJob(JobModel job);
	
	public List<JobModel> getJobList();
	
	public int deleteJob(@Param("jobID") String jobID);
	
	public List<JobModel> getJob(@Param("jobID") String jobID);
	
	public int updateJob(JobModel job);
	
}
