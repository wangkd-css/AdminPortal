package com.rmc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rmc.model.ServerModel;


@Mapper
//@Component
public interface ServerDao {
	

	public int addServer(ServerModel Server);
	
	public List<ServerModel> getServerList();
	
	public int deleteServer(@Param("serverID") String serverID);
	
	public List<ServerModel> getServer(@Param("serverID") String serverID);
	
	public int updateServer(ServerModel Server);
}
