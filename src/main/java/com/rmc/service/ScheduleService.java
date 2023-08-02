package com.rmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.dao.ScheduleDao;
import com.rmc.model.ScheduleModel;


@Service
public class ScheduleService {
	
	@Autowired
	ScheduleDao scheduleDao;


	public int addSchedule(ScheduleModel auto) {
		return scheduleDao.addSchedule(auto);
	}
	
	public List<ScheduleModel> getScheduleList(){
		return scheduleDao.getScheduleList();
	}

	public int deleteSchedule(String jobID , String runRate) {
		return scheduleDao.deleteSchedule(jobID,runRate);
	}
	
	public List<ScheduleModel> getSchedule(String jobID , String runRate){
		return scheduleDao.getSchedule(jobID,runRate);
	}
	
	public int updateSchedule(ScheduleModel auto) {
		return scheduleDao.updateSchedule(auto);
	}
}
