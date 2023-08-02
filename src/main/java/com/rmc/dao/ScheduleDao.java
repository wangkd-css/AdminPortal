package com.rmc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rmc.model.ScheduleModel;


@Mapper
//@Component
public interface ScheduleDao {
	

	public int addSchedule(ScheduleModel auto);
	
	public List<ScheduleModel> getScheduleList();
	
	public int deleteSchedule(@Param("jobID") String jobID,@Param("runRate") String runRate);
	
	public List<ScheduleModel> getSchedule(@Param("jobID") String jobID,@Param("runRate") String runRate);
	
	public int updateSchedule(ScheduleModel auto);
	
}
