package com.rmc.controller;				
				
			
import java.time.LocalDateTime;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.http.HttpServletRequest;				
import javax.servlet.http.HttpSession;				
				
import org.springframework.beans.factory.annotation.Autowired;				
import org.springframework.stereotype.Controller;				
import org.springframework.web.bind.annotation.RequestMapping;				
import org.springframework.web.bind.annotation.RequestMethod;				
import org.springframework.web.bind.annotation.ResponseBody;				
		
import com.rmc.model.BaseModel;				
import com.rmc.model.KeyWordModel;				
import com.rmc.service.KeyWordService;
import com.rmc.utils.Global;
import com.rmc.utils.TextUtils;				
			
				
@Controller				
@RequestMapping("/KeyWord")				
public class KeyWordController extends BaseController {				
				
	@Autowired			
	KeyWordService KeyWordService;			
				
	@ResponseBody			
	@RequestMapping(value ="/addKeyWord", method = RequestMethod.POST)			
	public BaseModel addKeyWord(HttpSession session,  KeyWordModel KeyWord) {			
		
		System.out.println(KeyWord.getAutomataId());
		System.out.println(KeyWord.getKeywordId());
		System.out.println(KeyWord.getKeyword());
		
		if (TextUtils.isEmpty(KeyWord.getKeywordId())) {		
			return makeModel(ERROR_CODE, "キーワード情報を入力してください");	
		}else {	
			KeyWord.setCreater(Global.getUserName());	
			KeyWord.setCreateTime(LocalDateTime.now());	
			KeyWord.setUpdater(Global.getUserName());	
			KeyWord.setUpdateTime(LocalDateTime.now());	
			
			int code = KeyWordService.addKeyWord(KeyWord);	
			if (code == 0) {	
				return makeModel(code, MSG_ADD_ERROR);
			} else {	
				return makeModel(code, MSG_ADD_SUCC);
			}	
		}		
	}			
				
	@ResponseBody			
	@RequestMapping("/KeyWordList")			
	public BaseModel getKeyWordList(HttpServletRequest request) {			
		List<KeyWordModel> models = KeyWordService.getKeyWordList();		
		return makeModel(SUCC_CODE, MSG_SUCC, models);		
				
	}			
				
	@ResponseBody			
	@RequestMapping("/deleteKeyWord")			
	public BaseModel deleteKeyWord(HttpSession session, String keywordId ) {			
				
		if (keywordId.isEmpty()) {			
			return makeModel(ERROR_CODE, "キーワードIDを確認ください。");	
		} else {		
			int code = KeyWordService.deleteKeyWord(keywordId);	
			if (code == 0) {	
				return makeModel(code, MSG_DELETE_ERROR);
			} else {	
				return makeModel(code, MSG_DELETE_SUCC);
			}	
				
		}		
	}			
				
	@ResponseBody			
	@RequestMapping("/getKeyWord")			
	public BaseModel getKeyWord(String keywordId) {			
		List<KeyWordModel> models = KeyWordService.getKeyWord(keywordId);		
		if (models == null || models.size() == 0) {		
			return makeModel(ERROR_CODE, "キーワードを確認ください。");	
		}		
		return makeModel(SUCC_CODE, MSG_SUCC, models);		
				
	}			
				
	@ResponseBody			
	@RequestMapping(value ="/updateKeyWord", method = RequestMethod.POST)			
	public BaseModel updateKeyWord(HttpSession session,  KeyWordModel KeyWord) {			
				
		if (TextUtils.isEmpty(KeyWord.getKeywordId())) {		
			return makeModel(ERROR_CODE, "キーワード情報を入力してください");	
		}else {		
			KeyWord.setUpdater(Global.getUserName());
			KeyWord.setUpdateTime(LocalDateTime.now());	
			
			int code = KeyWordService.updateKeyWord(KeyWord);	
			if (code == 0) {	
				return makeModel(code, MSG_ADD_ERROR);
			} else {	
				return makeModel(code, MSG_ADD_SUCC);
			}	
		}		
	}			
}				
