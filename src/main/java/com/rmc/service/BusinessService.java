package com.rmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rmc.dao.BusinessDao;
import com.rmc.model.BusinessModel;


@Service
public class BusinessService {
	
		
	@Autowired	
	BusinessDao Businessdao;	
		
		
	public int addBusiness(BusinessModel Business) {	
		return Businessdao.addBusiness(Business);
	}	
		
	public List<BusinessModel> getBusinessList(){	
		return Businessdao.getBusinessList();
	}	
		
	public int deleteBusiness(String id) {	
		return Businessdao.deleteBusiness(id);
	}	
		
	public List<BusinessModel> getBusiness(String BusinessID){	
		return Businessdao.getBusiness(BusinessID);
	}	
		
	public int updateBusiness(BusinessModel Business) {	
		return Businessdao.updateBusiness(Business);
	}	
}