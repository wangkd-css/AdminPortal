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
import com.rmc.model.BusinessModel;				
import com.rmc.service.BusinessService;				
import com.rmc.utils.Global;				
import com.rmc.utils.TextUtils;				
				
				
				
				
@Controller				
@RequestMapping("/Business")				
public class BusinessController extends BaseController {				
				
	@Autowired			
	BusinessService BusinessService;			
				
	@ResponseBody			
	@RequestMapping(value ="/addBusiness", method = RequestMethod.POST)			
	public BaseModel addBusiness(HttpSession session,  BusinessModel Business) {			
				
		if (TextUtils.isEmpty(Business.getBusinessID())) {		
			return makeModel(ERROR_CODE, "業務情報を入力してください");	
		}else {		
			Business.setCreater(Global.getUserName());	
			Business.setCreateTime(LocalDateTime.now());	
			Business.setUpdater(Global.getUserName());	
			Business.setUpdateTime(LocalDateTime.now());	
			int code = BusinessService.addBusiness(Business);	
			if (code == 0) {	
				return makeModel(code, MSG_ADD_ERROR);
			} else {	
				return makeModel(code, MSG_ADD_SUCC);
			}	
		}		
	}			
				
	@ResponseBody			
	@RequestMapping("/BusinessList")			
	public BaseModel getJobList(HttpServletRequest request) {
		List<BusinessModel> models = BusinessService.getBusinessList();
		return makeModel(SUCC_CODE, MSG_SUCC, models);

	}			
				
	@ResponseBody			
	@RequestMapping("/deleteBusiness")			
	public BaseModel deleteBusiness(HttpSession session, String BusinessID) {			
				
		if (TextUtils.isEmpty(BusinessID)) {		
			return makeModel(ERROR_CODE, "業務番号を確認ください。");	
		} else {		
			int code = BusinessService.deleteBusiness(BusinessID);	
			if (code == 0) {	
				return makeModel(code, MSG_DELETE_ERROR);
			} else {	
				return makeModel(code, MSG_DELETE_SUCC);
			}	
				
		}		
	}			
				
	@ResponseBody			
	@RequestMapping("/getBusiness")			
	public BaseModel getBusiness(String BusinessID)  {			
		List<BusinessModel> models = BusinessService.getBusiness(BusinessID);		
		if (models == null || models.size() == 0) {		
			return makeModel(ERROR_CODE, "業務番号を確認ください。");	
		}		
		return makeModel(SUCC_CODE, MSG_SUCC, models);		
				
	}			
				
	@ResponseBody			
	@RequestMapping(value ="/updateBusiness", method = RequestMethod.POST)			
	public BaseModel updateBusiness(HttpSession session,  BusinessModel Business) {			
				
		if (TextUtils.isEmpty(Business.getBusinessID()))  {		
			return makeModel(ERROR_CODE, "業務情報を入力してください");	
		}else {		
			Business.setUpdater(Global.getUserName());	
			Business.setUpdateTime(LocalDateTime.now());	
			int code = BusinessService.updateBusiness(Business);	
			if (code == 0) {	
				return makeModel(code, MSG_ADD_ERROR);
			} else {	
				return makeModel(code, MSG_ADD_SUCC);
			}	
		}		
	}			
}				
