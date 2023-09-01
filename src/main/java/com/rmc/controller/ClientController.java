package com.rmc.controller;				
				
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rmc.model.BaseModel;
import com.rmc.model.WorkflowModel;
import com.rmc.service.WorkflowService;
import com.rmc.utils.TextUtils;
import com.rmc.vo.AutomataVO;

import javax.annotation.Resource;			
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
				
	/**
     * 前端请求访问的接口
     * url workflow/queryUserStatus
     * @param filePath 参数：文件路径  例如“D:\robot-dev”
     * @return WorkFlowVO 返回结果 返回用户名称核用户状态的list集合对象
     */
	
    @RequestMapping(value ="/queryUserStatus",method = RequestMethod.GET)
    public List<AutomataVO> queryUserStatus(@RequestParam("filePath") String filePath) {
        return ClientService.queryUserStatus(filePath);
    }
}				
