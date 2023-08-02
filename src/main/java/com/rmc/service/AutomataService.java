package com.rmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.dao.AutomataDao;
import com.rmc.model.AutomataModel;


@Service
public class AutomataService {
	
	@Autowired
	AutomataDao autodao;


	public int addAuto(AutomataModel auto) {
		return autodao.addAuto(auto);
	}
	
	public List<AutomataModel> getAutoList(){
		return autodao.getAutoList();
	}

	public int deleteAuto(String id) {
		return autodao.deleteAuto(id);
	}
	
	public List<AutomataModel> getAuto(String automataID){
		return autodao.getAuto(automataID);
	}
	
	public int updateAuto(AutomataModel auto) {
		return autodao.updateAuto(auto);
	}
}
