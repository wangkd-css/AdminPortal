package com.rmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rmc.dao.LessonDao;
import com.rmc.model.LessonModel;


@Service
public class LessonService {
	
		
	@Autowired	
	LessonDao Lessondao;	
	//mapper
		
		
	/*
	 * public int addLesson(LessonModel Lesson) { return
	 * Lessondao.addLesson(Lesson); }
	 */
		
	public List<LessonModel> getLessonList(){	
		return Lessondao.getLessonList();
	}	
		
	/*
	 * public int deleteLesson(String id) { return Lessondao.deleteLesson(id); }
	 */
		
	public List<LessonModel> getLesson(String LessonID){	
		return Lessondao.getLesson(LessonID);
	}	
		
	public int updateLesson(LessonModel Lesson) {	
		return Lessondao.updateLesson(Lesson);
	}	
}