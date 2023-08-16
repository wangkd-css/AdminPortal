package com.rmc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rmc.model.BaseModel;
import com.rmc.model.WorkflowModel;
import com.rmc.service.WorkflowService;
import com.rmc.utils.TextUtils;

@Controller
@RequestMapping("/workflow")
public class WorkflowController extends BaseController {
	
	@Autowired
	WorkflowService workflowService;
	
	@ResponseBody
	@RequestMapping(value ="/addWorkflow", method = RequestMethod.POST)
	public BaseModel addWorkflow(HttpSession session,  WorkflowModel workflow) {
		
		if (workflow.getUserID() == null) {
			return makeModel(ERROR_CODE, "请输入用户信息");
		}else {
			int code = workflowService.addWorkflow(workflow);
			if (code == 0) {
				return makeModel(code, MSG_ADD_ERROR);
			} else {
				return makeModel(code, MSG_ADD_SUCC);
			}
		}
	}
	
	@ResponseBody
	@RequestMapping("/workflowList")
	public BaseModel getWorkflowList(HttpServletRequest request) {
		List<WorkflowModel> models = workflowService.getWorkflowList();
		return makeModel(SUCC_CODE, MSG_SUCC, models);

	}
	
	@ResponseBody
	@RequestMapping("/deleteWorkflow")
	/*
	 * public BaseModel deleteWorkflow(HttpSession session, String jobID , String
	 * status) {
	 */
	public BaseModel deleteWorkflow(HttpSession session, String userID) {
		
		if (TextUtils.isEmpty(userID)) {
			return makeModel(ERROR_CODE, "请确认用户名。");
		} else {
			/* int code = workflowService.deleteWorkflow(jobID,status); */
			int code = workflowService.deleteWorkflow(userID);
			if (code == 0) {
				return makeModel(code, MSG_DELETE_ERROR);
			} else {
				return makeModel(code, MSG_DELETE_SUCC);
			}

		}
	}
	
	@ResponseBody
	@RequestMapping("/getWorkflow")
	/*
	 * public BaseModel getWorkflow(String jobID,String status) {
	 * List<WorkflowModel> models = workflowService.getWorkflow(jobID,status);
	 */
	public BaseModel getWorkflow(String userID) {
		List<WorkflowModel> models = workflowService.getWorkflow(userID);	
		if (models == null || models.size() == 0) {
			return makeModel(ERROR_CODE, "请确认用户名。");
		}
		return makeModel(SUCC_CODE, MSG_SUCC, models);

	}
	
	@ResponseBody
	@RequestMapping(value ="/updateWorkflow", method = RequestMethod.POST)
	public BaseModel updateWorkflow(HttpSession session,  WorkflowModel workflow) {
		
		if (workflow.getUserID() == null) {
			return makeModel(ERROR_CODE, "请输入用户信息");
		}else {
			int code = workflowService.updateWorkflow(workflow);
			if (code == 0) {
				return makeModel(code, MSG_ADD_ERROR);
			} else {
				return makeModel(code, MSG_ADD_SUCC);
			}
		}
	}
}
