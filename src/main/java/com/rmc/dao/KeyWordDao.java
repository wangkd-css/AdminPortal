package com.rmc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.rmc.model.KeyWordModel;


@Mapper
//@Component
public interface KeyWordDao {
	

	public int addKeyWord(KeyWordModel KeyWord);
	
	public List<KeyWordModel> getKeyWordList();
	
	public int deleteKeyWord(@Param("keywordId") String keywordId);
	
	public List<KeyWordModel> getKeyWord(@Param("keywordId") String keywordId);
	
	public int updateKeyWord(KeyWordModel KeyWord);
	
}
