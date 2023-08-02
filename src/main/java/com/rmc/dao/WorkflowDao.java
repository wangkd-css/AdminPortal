package com.rmc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rmc.model.WorkflowModel;


@Mapper
//@Component
public interface WorkflowDao {
	

	public int addWorkflow(WorkflowModel workflow);
	
	public List<WorkflowModel> getWorkflowList();
	
	/*
	 * public int deleteWorkflow(@Param("jobID") String jobID,@Param("status")
	 * String status);
	 * 
	 * public List<WorkflowModel> getWorkflow(@Param("jobID") String
	 * jobID,@Param("status") String status);
	 */
	public int deleteWorkflow(@Param("jobID") String jobID);
	
	public List<WorkflowModel> getWorkflow(@Param("jobID") String jobID);
	
	public int updateWorkflow(WorkflowModel workflow);
	
}
