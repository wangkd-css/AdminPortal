package com.rmc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.rmc.model.ClientModel;


@Mapper
//@Component
public interface ClientDao {
	

	public int addClient(ClientModel Client);
	
	public List<ClientModel> getClientList();
	
	public int deleteClient(@Param("customerID") String customerID);
	
	public List<ClientModel> getClient(@Param("customerID") String customerID);
	
	public int updateClient(ClientModel Client);
}
