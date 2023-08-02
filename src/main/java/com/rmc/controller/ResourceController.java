package com.rmc.controller;				
				
import java.time.LocalDateTime;				
import java.util.List;				
				
import javax.servlet.http.HttpServletRequest;				
import javax.servlet.http.HttpSession;				
				
import org.springframework.beans.factory.annotation.Autowired;				
import org.springframework.stereotype.Controller;				
import org.springframework.web.bind.annotation.RequestMapping;				
import org.springframework.web.bind.annotation.RequestMethod;				
import org.springframework.web.bind.annotation.ResponseBody;				
				
import com.rmc.model.AutomataModel;				
import com.rmc.model.BaseModel;				
import com.rmc.model.ResourceModel;				
import com.rmc.service.ResourceService;				
import com.rmc.utils.TextUtils;				
				
@Controller				
@RequestMapping("/Resource")				
public class ResourceController extends BaseController {				
				
	@Autowired			
	ResourceService ResourceService;			
				
	@ResponseBody			
	@RequestMapping(value ="/addResource", method = RequestMethod.POST)			
	public BaseModel addResource(HttpSession session,  ResourceModel Resource) {			
				
		if (Resource.getResourceID() == 0) {		
			return makeModel(ERROR_CODE, "リソース情報を入力してください");	
		}else {		
			int code = ResourceService.addResource(Resource);	
			if (code == 0) {	
				return makeModel(code, MSG_ADD_ERROR);
			} else {	
				return makeModel(code, MSG_ADD_SUCC);
			}	
		}		
	}			
				
	@ResponseBody			
	@RequestMapping("/ResourceList")			
	public BaseModel getResourceList(HttpServletRequest request) {			
		List<ResourceModel> models = ResourceService.getResourceList();		
		return makeModel(SUCC_CODE, MSG_SUCC, models);		
				
	}			
				
	@ResponseBody			
	@RequestMapping("/deleteResource")			
	public BaseModel deleteResource(HttpSession session, String resourceID) {			
				
		if (TextUtils.isEmpty(resourceID)) {		
			return makeModel(ERROR_CODE, "リソースIDを確認ください。");	
		} else {		
			int code = ResourceService.deleteResource(resourceID);	
			if (code == 0) {	
				return makeModel(code, MSG_DELETE_ERROR);
			} else {	
				return makeModel(code, MSG_DELETE_SUCC);
			}	
				
		}		
	}			
				
	@ResponseBody			
	@RequestMapping("/getResource")			
	public BaseModel getResource(String resourceID) {			
		List<ResourceModel> models = ResourceService.getResource(resourceID);		
		if (models == null || models.size() == 0) {		
			return makeModel(ERROR_CODE, "リソースIDを確認ください。");	
		}		
		return makeModel(SUCC_CODE, MSG_SUCC, models);		
				
	}			
				
	@ResponseBody			
	@RequestMapping(value ="/updateResource", method = RequestMethod.POST)			
	public BaseModel updateResource(HttpSession session,  ResourceModel Resource) {			
				
		if (Resource.getResourceID() == 0) {		
			return makeModel(ERROR_CODE, "	リソース情報を入力してください");	
		}else {		
			int code = ResourceService.updateResource(Resource);	
			if (code == 0) {	
				return makeModel(code, MSG_ADD_ERROR);
			} else {	
				return makeModel(code, MSG_ADD_SUCC);
			}	
		}		
	}			
}				
