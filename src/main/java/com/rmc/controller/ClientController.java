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
				
import com.rmc.model.BaseModel;
import com.rmc.model.ClientModel;				
import com.rmc.service.ClientService;				
import com.rmc.utils.Global;				
import com.rmc.utils.TextUtils;				
				
				
				
				
@Controller				
@RequestMapping("/Client")				
public class ClientController extends BaseController {				
				
	@Autowired			
	ClientService ClientService;			
				
	@ResponseBody			
	@RequestMapping(value ="/addClient", method = RequestMethod.POST)			
	public BaseModel addClient(HttpSession session,  ClientModel Client) {			
				
		if (TextUtils.isEmpty(Client.getCustomerID())) {		
			return makeModel(ERROR_CODE, "お客様情報を入力してください");	
		}else {		
			Client.setCreater(Global.getUserName());	
			Client.setCreateTime(LocalDateTime.now());	
			Client.setUpdater(Global.getUserName());	
			Client.setUpdateTime(LocalDateTime.now());	
			int code = ClientService.addClient(Client);	
			if (code == 0) {	
				return makeModel(code, MSG_ADD_ERROR);
			} else {	
				return makeModel(code, MSG_ADD_SUCC);
			}	
		}		
	}			
				
	@ResponseBody			
	@RequestMapping("/ClientList")			
	public BaseModel getClientList(HttpServletRequest request) {
		List<ClientModel> models = ClientService.getClientList();
		return makeModel(SUCC_CODE, MSG_SUCC, models);

	}			
				
	@ResponseBody			
	@RequestMapping("/deleteClient")			
	public BaseModel deleteClient(HttpSession session, String CustomerID) {			
				
		if (TextUtils.isEmpty(CustomerID)) {		
			return makeModel(ERROR_CODE, "お客様番号を確認ください。");	
		} else {		
			int code = ClientService.deleteClient(CustomerID);	
			if (code == 0) {	
				return makeModel(code, MSG_DELETE_ERROR);
			} else {	
				return makeModel(code, MSG_DELETE_SUCC);
			}	
				
		}		
	}			
				
	@ResponseBody			
	@RequestMapping("/getClient")			
	public BaseModel getClient(String CustomerID)  {			
		List<ClientModel> models = ClientService.getClient(CustomerID);		
		if (models == null || models.size() == 0) {		
			return makeModel(ERROR_CODE, "お客様番号を確認ください。");	
		}		
		return makeModel(SUCC_CODE, MSG_SUCC, models);		
				
	}			
				
	@ResponseBody			
	@RequestMapping(value ="/updateClient", method = RequestMethod.POST)			
	public BaseModel updateClient(HttpSession session,  ClientModel Client) {			
				
		if (TextUtils.isEmpty(Client.getCustomerID()))  {		
			return makeModel(ERROR_CODE, "お客様情報を入力してください");	
		}else {		
			Client.setUpdater(Global.getUserName());	
			Client.setUpdateTime(LocalDateTime.now());	
			int code = ClientService.updateClient(Client);	
			if (code == 0) {	
				return makeModel(code, MSG_ADD_ERROR);
			} else {	
				return makeModel(code, MSG_ADD_SUCC);
			}	
		}		
	}			
}				
