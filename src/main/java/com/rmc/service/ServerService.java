package com.rmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rmc.dao.ServerDao;
import com.rmc.model.ServerModel;


@Service
public class ServerService {
	
		
	@Autowired	
	ServerDao Serverdao;	
		
		
	public int addServer(ServerModel Server) {	
		return Serverdao.addServer(Server);
	}	
		
	public List<ServerModel> getServerList(){	
		return Serverdao.getServerList();
	}	
		
	public int deleteServer(String id) {	
		return Serverdao.deleteServer(id);
	}	
		
	public List<ServerModel> getServer(String serverID){	
		return Serverdao.getServer(serverID);
	}	
		
	public int updateServer(ServerModel Server) {	
		return Serverdao.updateServer(Server);
	}	
		
}