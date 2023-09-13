package com.rmc.service;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.dao.AutomataDao;
import com.rmc.model.AutomataModel;
import com.rmc.vo.AutomataVO;


@Service
public class AutomataService {
	
	@Autowired
	AutomataDao autodao;

	public int addAuto(AutomataModel auto) {
		return autodao.addAuto(auto);
	}
	
	public List<AutomataModel> getAutoList(){
		return autodao.getAutoList();
	}

	public int deleteAuto(String id) {
		return autodao.deleteAuto(id);
	}
	
	public List<AutomataModel> getAuto(String automataID){
		return autodao.getAuto(automataID);
	}
	
	public int updateAuto(AutomataModel auto) {
		return autodao.updateAuto(auto);
	}
	/**
	 * 查询用户名称和状态
	 * 
	 * @param filePath filePath
	 * @return
	 */
	public List<AutomataVO> queryUserStatus(String filePath) {
		// 获取所有的文件名称
		String fileDir = "C:\\Users\\009740672\\Box\\2023韩（DR）\\已完成事项\\";
		String targetDirectory = fileDir + filePath;
		List<String> fileNames = getFileNames(targetDirectory);
		List<String> fileNameArray = new ArrayList<>();
		for (String fileName : fileNames) {
			// 按照“zhangsan_2023xxx”进行处理
			String[] split = fileName.split("_");
			// 获取用户名称
			fileNameArray.add(split[0]);
		}
//		System.out.println("获取数组长度："+fileNameArray.size());
		// 筛选出已完成作业的用户名称
		List<AutomataModel> AutomataModels = autodao.queryUserInfoByUserNames();
		List<AutomataVO> AutomataVOList = new ArrayList<>();
		// 筛选文件夹下的用户是否是数据库中的用户
		for (AutomataModel automataModel : AutomataModels) {
			AutomataVO AutomataVO = new AutomataVO();
			AutomataVO.setUserName(automataModel.getUserID());
			// 如果文件夹下的用户是数据库中的用户则用户状态展示已完成
			if (fileNameArray.contains(AutomataVO.getUserName())) {
				AutomataVO.setUserStatus("已完成");
            } else {
            	AutomataVO.setUserStatus("未完成");
            }
			AutomataVOList.add(AutomataVO);
		}
//		System.out.println("获取完成状态长度："+AutomataVOList.size());
		return AutomataVOList;
	}

	/**
	 * 根据文件路径获取文件名称
	 *
	 * @param targetDirectory path
	 * @return
	 */
	private List<String> getFileNames(String targetDirectory) {
		File file = new File(targetDirectory);
		if (!file.exists()) {
			return null;
		}
		List<String> fileNames = new ArrayList<>();
		return getFileNames(file, fileNames);
	}
		  /**
		    * 递归获取文件夹下的所有文件名称（包括根目录子目录）
		    *
		    * @param file      file
		    * @param fileNames fileNames
		    * @return
		    */
		   private List<String> getFileNames(File file, List<String> fileNames) {
		        File[] files = file.listFiles();
		        for (File f : files) {
		        	 //如果是文件夹继续获取文件夹下面的所有文件
		             if (f.isDirectory()) {
		                  getFileNames(f, fileNames);
		             } else {
		            	  //不是文件夹则获取文件名
		                  fileNames.add(f.getName());
		             }
		        }
		        return fileNames;
		   }
}
