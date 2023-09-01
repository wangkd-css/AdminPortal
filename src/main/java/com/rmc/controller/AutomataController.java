package com.rmc.controller;

import java.time.LocalDateTime;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rmc.model.AutomataModel;
import com.rmc.model.BaseModel;
import com.rmc.model.QueryUserStatusReqModel;
import com.rmc.service.AutomataService;
import com.rmc.utils.Global;
import com.rmc.utils.TextUtils;
import com.rmc.vo.AutomataVO;

@Controller
@RequestMapping("/auto")
public class AutomataController extends BaseController {
	
	@Autowired
	AutomataService autoService;
	
	@ResponseBody
	@RequestMapping(value ="/addAuto", method = RequestMethod.POST)
	public BaseModel addAuto(HttpSession session,  AutomataModel automata) {
		
		if (automata.getAutomataID() == null) {
			return makeModel(ERROR_CODE, "请输入用户信息");
		}else {
			SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			automata.setCreater(Global.getUserName());
			automata.setCreateTime(LocalDateTime.now());
			automata.setUpdater(Global.getUserName());
			automata.setUpdateTime(LocalDateTime.now());
			int code = autoService.addAuto(automata);
			if (code == 0) {
				return makeModel(code, MSG_ADD_ERROR);
			} else {
				return makeModel(code, MSG_ADD_SUCC);
			}
		}
	}
	
	@ResponseBody
	@RequestMapping("/autoList")
	public BaseModel getAutoList(HttpServletRequest request) {
		List<AutomataModel> models = autoService.getAutoList();
		String showType;
		for(int i=0;i<models.size();i++) {
			showType = models.get(i).getComent(models.get(i).getAutomataType());
			models.get(i).setShowType(showType);
		}
		return makeModel(SUCC_CODE, MSG_SUCC, models);

	}
	
	@ResponseBody
	@RequestMapping("/deleteAuto")
	public BaseModel deleteAuto(HttpSession session, String automataID) {
		
		if (TextUtils.isEmpty(automataID)) {
			return makeModel(ERROR_CODE, "请确认用户名。");
		} else {
			int code = autoService.deleteAuto(automataID);
			if (code == 0) {
				return makeModel(code, MSG_DELETE_ERROR);
			} else {
				return makeModel(code, MSG_DELETE_SUCC);
			}

		}
	}
	
	@ResponseBody
	@RequestMapping("/getAuto")
	public BaseModel getAuto(String automataID) {
		List<AutomataModel> models = autoService.getAuto(automataID);
		if (models == null || models.size() == 0) {
			return makeModel(ERROR_CODE, "请确认用户名。");
		}
		return makeModel(SUCC_CODE, MSG_SUCC, models);

	}
	
	@ResponseBody
	@RequestMapping(value ="/updateAuto", method = RequestMethod.POST)
	public BaseModel updateAuto(HttpSession session,  AutomataModel automata) {
		
		if (automata.getAutomataID() == null) {
			return makeModel(ERROR_CODE, "请输入用户信息");
		}else {
			automata.setUpdater(Global.getUserName());
			automata.setUpdateTime(LocalDateTime.now());
			int code = autoService.updateAuto(automata);
			if (code == 0) {
				return makeModel(code, MSG_ADD_ERROR);
			} else {
				return makeModel(code, MSG_ADD_SUCC);
			}
		}
	}
	/**
     * 前端请求访问的接口
     * url auto/queryUserStatus
     * @param filePath 参数：文件路径  例如“D:\robot-dev”
     * @return AutomataVO 返回结果 返回用户名称和用户状态的list集合对象
     */
	@ResponseBody
    @RequestMapping(value ="/queryUserStatus", method = RequestMethod.POST)
    public List<AutomataVO> queryUserStatus(HttpSession session, QueryUserStatusReqModel requestModel) {
		System.out.println("filePath=" + requestModel.getFilePath());
		return autoService.queryUserStatus(requestModel.getFilePath());
    }
}
