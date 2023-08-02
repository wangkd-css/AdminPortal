package com.rmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.dao.WorkflowDao;
import com.rmc.model.WorkflowModel;


@Service
public class WorkflowService {
	
	@Autowired
	WorkflowDao workflowDao;


	public int addWorkflow(WorkflowModel workflow) {
		return workflowDao.addWorkflow(workflow);
	}
	
	public List<WorkflowModel> getWorkflowList(){
		return workflowDao.getWorkflowList();
	}

	/*
	 * public int deleteWorkflow(String id,String status) { return
	 * workflowDao.deleteWorkflow(id,status); }
	 */
	public int deleteWorkflow(String id) {
		return workflowDao.deleteWorkflow(id);
	}
	
	/*
	 * public List<WorkflowModel> getWorkflow(String jobID,String status){ return
	 * workflowDao.getWorkflow(jobID,status); }
	 */
	public List<WorkflowModel> getWorkflow(String jobID){
		return workflowDao.getWorkflow(jobID);
	}
	
	public int updateWorkflow(WorkflowModel workflow) {
		return workflowDao.updateWorkflow(workflow);
	}
}
