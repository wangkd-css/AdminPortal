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

import com.rmc.model.BaseModel;
import com.rmc.model.ScheduleModel;
import com.rmc.service.ScheduleService;
import com.rmc.utils.Global;
import com.rmc.utils.TextUtils;




@Controller
@RequestMapping("/schedule")
public class ScheduleController extends BaseController {
	
	@Autowired
	ScheduleService scheduleService;
	
	@ResponseBody
	@RequestMapping(value ="/addSchedule", method = RequestMethod.POST)
	public BaseModel addSchedule(HttpSession session,  ScheduleModel schedule) {
		
		if (schedule.getJobID() == 0) {
			return makeModel(ERROR_CODE, "スケジュール情報を入力してください");
		}else {
			schedule.setCreater(Global.getUserName());
			schedule.setCreateTime(LocalDateTime.now());
			schedule.setUpdater(Global.getUserName());
			schedule.setUpdateTime(LocalDateTime.now());
			int code = scheduleService.addSchedule(schedule);
			if (code == 0) {
				return makeModel(code, MSG_ADD_ERROR);
			} else {
				return makeModel(code, MSG_ADD_SUCC);
			}
		}
	}
	
	@ResponseBody
	@RequestMapping("/scheduleList")
	public BaseModel getScheduleList(HttpServletRequest request) {
		List<ScheduleModel> models = scheduleService.getScheduleList();
		String showType;
		for(int i=0;i<models.size();i++) {
			showType = models.get(i).getComent(models.get(i).getRunRate());
			models.get(i).setShowType(showType);
		}
		return makeModel(SUCC_CODE, MSG_SUCC, models);

	}
	
	@ResponseBody
	@RequestMapping("/deleteSchedule")
	public BaseModel deleteSchedule(HttpSession session, String jobID , String runRate) {
		
		if (TextUtils.isEmpty(jobID)) {
			return makeModel(ERROR_CODE, "ジョブIDを確認ください。");
		} else {
			int code = scheduleService.deleteSchedule(jobID,runRate);
			if (code == 0) {
				return makeModel(code, MSG_DELETE_ERROR);
			} else {
				return makeModel(code, MSG_DELETE_SUCC);
			}

		}
	}
	
	@ResponseBody
	@RequestMapping("/getSchedule")
	public BaseModel getSchedule(String jobID , String runRate) {
		List<ScheduleModel> models = scheduleService.getSchedule(jobID,runRate);
		if (models == null || models.size() == 0) {
			return makeModel(ERROR_CODE, "ジョブIDを確認ください。");
		}
		return makeModel(SUCC_CODE, MSG_SUCC, models);

	}
	
	@ResponseBody
	@RequestMapping(value ="/updateSchedule", method = RequestMethod.POST)
	public BaseModel updateSchedule(HttpSession session,  ScheduleModel schedule) {
		
		if (schedule.getJobID() == 0) {
			return makeModel(ERROR_CODE, "スケジュール情報を入力してください");
		}else {
			schedule.setUpdater(Global.getUserName());
			schedule.setUpdateTime(LocalDateTime.now());
			int code = scheduleService.updateSchedule(schedule);
			if (code == 0) {
				return makeModel(code, MSG_ADD_ERROR);
			} else {
				return makeModel(code, MSG_ADD_SUCC);
			}
		}
	}
}
