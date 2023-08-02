package com.rmc.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rmc.model.AutomataModel;
import com.rmc.model.BaseModel;
import com.rmc.model.JobModel;
import com.rmc.service.JobService;
import com.rmc.utils.TextUtils;

@Controller
@RequestMapping("/job")
public class JobController extends BaseController {
	
	@Autowired
	JobService jobService;
	
	@ResponseBody
	@RequestMapping(value ="/addJob", method = RequestMethod.POST)
	public BaseModel addJob(HttpSession session,  JobModel job) {
		
		if (job.getJobID() == 0) {
			return makeModel(ERROR_CODE, "ジョブ情報を入力してください");
		}else {
			int code = jobService.addJob(job);
			if (code == 0) {
				return makeModel(code, MSG_ADD_ERROR);
			} else {
				return makeModel(code, MSG_ADD_SUCC);
			}
		}
	}
	
	@ResponseBody
	@RequestMapping("/jobList")
	public BaseModel getJobList(HttpServletRequest request) {
		List<JobModel> models = jobService.getJobList();
		return makeModel(SUCC_CODE, MSG_SUCC, models);

	}
	
	@ResponseBody
	@RequestMapping("/deleteJob")
	public BaseModel deleteJob(HttpSession session, String jobID) {
		
		if (TextUtils.isEmpty(jobID)) {
			return makeModel(ERROR_CODE, "ジョブIDを確認ください。");
		} else {
			int code = jobService.deleteJob(jobID);
			if (code == 0) {
				return makeModel(code, MSG_DELETE_ERROR);
			} else {
				return makeModel(code, MSG_DELETE_SUCC);
			}

		}
	}
	
	@ResponseBody
	@RequestMapping("/getJob")
	public BaseModel getJob(String jobID) {
		List<JobModel> models = jobService.getJob(jobID);
		if (models == null || models.size() == 0) {
			return makeModel(ERROR_CODE, "ジョブIDを確認ください。");
		}
		return makeModel(SUCC_CODE, MSG_SUCC, models);

	}
	
	@ResponseBody
	@RequestMapping(value ="/updateJob", method = RequestMethod.POST)
	public BaseModel updateJob(HttpSession session,  JobModel job) {
		
		if (job.getJobID() == 0) {
			return makeModel(ERROR_CODE, "オートマタ情報を入力してください");
		}else {
			int code = jobService.updateJob(job);
			if (code == 0) {
				return makeModel(code, MSG_ADD_ERROR);
			} else {
				return makeModel(code, MSG_ADD_SUCC);
			}
		}
	}
}
