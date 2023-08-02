package com.rmc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.rmc.model.BusinessModel;


@Mapper
//@Component
public interface BusinessDao {
	

	public int addBusiness(BusinessModel Business);
	
	public List<BusinessModel> getBusinessList();
	
	public int deleteBusiness(@Param("BusinessID") String BusinessID);
	
	public List<BusinessModel> getBusiness(@Param("BusinessID") String BusinessID);
	
	public int updateBusiness(BusinessModel Business);
}
