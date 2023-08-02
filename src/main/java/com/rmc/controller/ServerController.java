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
import com.rmc.model.ServerModel;				
import com.rmc.service.ServerService;				
import com.rmc.utils.Global;				
import com.rmc.utils.TextUtils;				
				
				
				
				
@Controller				
@RequestMapping("/Server")				
public class ServerController extends BaseController {				
				
	@Autowired			
	ServerService ServerService;			
				
	@ResponseBody			
	@RequestMapping(value ="/addServer", method = RequestMethod.POST)			
	public BaseModel addServer(HttpSession session,  ServerModel Server) {			
				
		if (Server.getServerID() == 0) {		
			return makeModel(ERROR_CODE, "サーバ情報を入力してください");	
		}else {		
			Server.setCreater(Global.getUserName());	
			Server.setCreateTime(LocalDateTime.now());	
			Server.setUpdater(Global.getUserName());	
			Server.setUpdateTime(LocalDateTime.now());	
			int code = ServerService.addServer(Server);	
			if (code == 0) {	
				return makeModel(code, MSG_ADD_ERROR);
			} else {	
				return makeModel(code, MSG_ADD_SUCC);
			}	
		}		
	}			
				
	@ResponseBody			
	@RequestMapping("/ServerList")			
	public BaseModel getJobList(HttpServletRequest request) {
		List<ServerModel> models = ServerService.getServerList();
		return makeModel(SUCC_CODE, MSG_SUCC, models);

	}			
				
	@ResponseBody			
	@RequestMapping("/deleteServer")			
	public BaseModel deleteServer(HttpSession session, String serverID) {			
				
		if (TextUtils.isEmpty(serverID)) {		
			return makeModel(ERROR_CODE, "サーバIDを確認ください。");	
		} else {		
			int code = ServerService.deleteServer(serverID);	
			if (code == 0) {	
				return makeModel(code, MSG_DELETE_ERROR);
			} else {	
				return makeModel(code, MSG_DELETE_SUCC);
			}	
				
		}		
	}			
				
	@ResponseBody			
	@RequestMapping("/getServer")			
	public BaseModel getServer(String serverID)  {			
		List<ServerModel> models = ServerService.getServer(serverID);		
		if (models == null || models.size() == 0) {		
			return makeModel(ERROR_CODE, "サーバIDを確認ください。");	
		}		
		return makeModel(SUCC_CODE, MSG_SUCC, models);		
				
	}			
				
	@ResponseBody			
	@RequestMapping(value ="/updateServer", method = RequestMethod.POST)			
	public BaseModel updateServer(HttpSession session,  ServerModel Server) {			
				
		if (Server.getServerID() == 0) {		
			return makeModel(ERROR_CODE, "サーバ情報を入力してください");	
		}else {		
			Server.setUpdater(Global.getUserName());	
			Server.setUpdateTime(LocalDateTime.now());	
			int code = ServerService.updateServer(Server);	
			if (code == 0) {	
				return makeModel(code, MSG_ADD_ERROR);
			} else {	
				return makeModel(code, MSG_ADD_SUCC);
			}	
		}		
	}			
}				
