package com.rmc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.rmc.model.LessonModel;


@Mapper
//@Component
public interface LessonDao {
	

	public int addLesson(LessonModel Lesson);
	
	public List<LessonModel> getLessonList(@Param("userName1") String userName1);
	
	/* public int deleteLesson(@Param("LessonID") String LessonID); */
	
	public List<LessonModel> getLesson(@Param("automataID") String automataID);
	
	public int updateLesson(LessonModel Lesson);
}
