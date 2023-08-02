package com.rmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rmc.dao.ResourceDao;

import com.rmc.model.ResourceModel;


@Service
public class ResourceService {
	
	
	@Autowired	
	ResourceDao Resourcedao;	
		
		
	public int addResource(ResourceModel Resource) {	
		return Resourcedao.addResource(Resource);
	}	
		
	public List<ResourceModel> getResourceList(){	
		return Resourcedao.getResourceList();
	}	
		
	public int deleteResource(String id) {	
		return Resourcedao.deleteResource(id);
	}	
		
	public List<ResourceModel> getResource(String ResourceID){	
		return Resourcedao.getResource(ResourceID);
	}	
		
	public int updateResource(ResourceModel Resource) {	
		return Resourcedao.updateResource(Resource);
	}	
}
