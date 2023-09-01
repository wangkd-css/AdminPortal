package com.rmc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rmc.model.AutomataModel;


@Mapper
//@Component
public interface AutomataDao {
	

	public int addAuto(AutomataModel auto);
	
	public List<AutomataModel> getAutoList();
	
	public int deleteAuto(@Param("automataID") String automataID);
	
	public List<AutomataModel> getAuto(@Param("automataID") String automataID);
	
	public int updateAuto(AutomataModel auto);
	/**
	 *
	 * @param userNames userNames 图片的用户名集合
	 * @return
	 */
	List<AutomataModel> queryUserInfoByUserNames(@Param(value = "userNames") List<String> userNames);
	
}
