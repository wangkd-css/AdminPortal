package com.rmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rmc.dao.ClientDao;
import com.rmc.model.ClientModel;
import com.rmc.model.KeyWordModel;


@Service
public class ClientService {
	
	@Autowired	
	ClientDao Clientdao;	
		
		
	public int addClient(ClientModel Client) {	
		return Clientdao.addClient(Client);
	}	
		
	public List<ClientModel> getClientList(){	
		return Clientdao.getClientList();
	}	
		
	public int deleteClient(String id) {	
		return Clientdao.deleteClient(id);
	}	
		
	public List<ClientModel> getClient(String customerID){	
		return Clientdao.getClient(customerID);
	}	
		
	public int updateClient(ClientModel Client) {	
		return Clientdao.updateClient(Client);
	}	
		
}