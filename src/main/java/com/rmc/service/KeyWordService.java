package com.rmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rmc.dao.KeyWordDao;
import com.rmc.model.KeyWordModel;


@Service
public class KeyWordService {
	
	@Autowired	
	KeyWordDao KeyWorddao;	
		
		
	public int addKeyWord(KeyWordModel KeyWord) {	
		return KeyWorddao.addKeyWord(KeyWord);
	}	
		
	public List<KeyWordModel> getKeyWordList(){	
		return KeyWorddao.getKeyWordList();
	}	
		
	public int deleteKeyWord(String id) {	
		return KeyWorddao.deleteKeyWord(id);
	}	
		
	public List<KeyWordModel> getKeyWord(String KeyWordID){	
		return KeyWorddao.getKeyWord(KeyWordID);
	}	
		
	public int updateKeyWord(KeyWordModel KeyWord) {	
		return KeyWorddao.updateKeyWord(KeyWord);
	}	
}		
