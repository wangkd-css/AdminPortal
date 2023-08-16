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
import com.rmc.model.LessonModel;				
import com.rmc.service.LessonService;				
import com.rmc.utils.Global;				
import com.rmc.utils.TextUtils;				
				
				
				
				
@Controller				
@RequestMapping("/Lesson")				
public class LessonController extends BaseController {				
				
	@Autowired			
	LessonService LessonService;			
				
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value ="/addLesson", method = RequestMethod.POST) public
	 * BaseModel addLesson(HttpSession session, LessonModel Lesson) {
	 * 
	 * if (TextUtils.isEmpty(Lesson.getLessonID())) { return makeModel(ERROR_CODE,
	 * "業務情報を入力してください"); }else { Lesson.setCreater(Global.getUserName());
	 * Lesson.setCreateTime(LocalDateTime.now());
	 * Lesson.setUpdater(Global.getUserName());
	 * Lesson.setUpdateTime(LocalDateTime.now()); int code =
	 * LessonService.addLesson(Lesson); if (code == 0) { return makeModel(code,
	 * MSG_ADD_ERROR); } else { return makeModel(code, MSG_ADD_SUCC); } } }
	 */			
				
	@ResponseBody			
	@RequestMapping("/LessonList")			
	public BaseModel getJobList(HttpServletRequest request) {
		List<LessonModel> models = LessonService.getLessonList();
		return makeModel(SUCC_CODE, MSG_SUCC, models);

	}			
				
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/deleteLesson") public BaseModel deleteLesson(HttpSession
	 * session, String LessonID) {
	 * 
	 * if (TextUtils.isEmpty(LessonID)) { return makeModel(ERROR_CODE,
	 * "業務番号を確認ください。"); } else { int code = LessonService.deleteLesson(LessonID); if
	 * (code == 0) { return makeModel(code, MSG_DELETE_ERROR); } else { return
	 * makeModel(code, MSG_DELETE_SUCC); }
	 * 
	 * } }
	 */		
				
	@ResponseBody			
	@RequestMapping("/getLesson")			
	public BaseModel getLesson(String LessonID)  {			
		List<LessonModel> models = LessonService.getLesson(LessonID);		
		if (models == null || models.size() == 0) {		
			return makeModel(ERROR_CODE, "業務番号を確認ください。");	
		}		
		return makeModel(SUCC_CODE, MSG_SUCC, models);		
				
	}			
				
	@ResponseBody			
	@RequestMapping(value ="/updateLesson", method = RequestMethod.POST)			
	public BaseModel updateLesson(HttpSession session,  LessonModel Lesson) {			
				
		if (TextUtils.isEmpty(Lesson.getLessonID()))  {		
			return makeModel(ERROR_CODE, "業務情報を入力してください");	
		}else {		
			Lesson.setUpdater(Global.getUserName());	
			Lesson.setUpdateTime(LocalDateTime.now());	
			int code = LessonService.updateLesson(Lesson);	
			if (code == 0) {	
				return makeModel(code, MSG_ADD_ERROR);
			} else {	
				return makeModel(code, MSG_ADD_SUCC);
			}	
		}		
	}			
}				
