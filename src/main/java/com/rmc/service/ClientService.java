package com.rmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.dao.ClientDao;
import com.rmc.model.ClientModel;
import com.rmc.vo.AutomataVO;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;
import com.rmc.model.KeyWordModel;

@Service
public class ClientService {

	@Autowired
	ClientDao ClientDao;

	/**
	 * 查询用户名称和状态
	 * 
	 * @param filePath filePath
	 * @return
	 */
	public List<AutomataVO> queryUserStatus(String filePath) {
		// 获取所有的文件名称
		List<String> fileNames = getFileNames(filePath);
		List<String> fileNameArray = new ArrayList<>();
		for (String fileName : fileNames) {
			// 按照“zhangsan_2023xxx”进行处理
			String[] split = fileName.split("_");
			// 获取用户名称
			fileNameArray.add(split[0]);
		}
		// 筛选出已完成作业的用户名称
		List<ClientModel> ClientModels = ClientDao.queryUserInfoByUserNames(fileNameArray);
		List<String> completeUserName = new ArrayList<>();
		for (ClientModel ClientModel : ClientModels) {
			completeUserName.add(ClientModel.getUserID());
		}
		List<AutomataVO> ClientVOList = new ArrayList<>();
		// 筛选文件夹下的用户是否是数据库中的用户
		for (String userName : fileNameArray) {
			AutomataVO ClientVO = new AutomataVO();
			ClientVO.setUserName(userName);
			ClientVO.setUserStatus("未完成");
			// 如果文件夹下的用户是数据库中的用户则用户状态展示已完成
			if (completeUserName.contains(userName)) {
				ClientVO.setUserStatus("已完成");
			}
			ClientVOList.add(ClientVO);
		}
		return ClientVOList;
	}

	/**
	 * 根据文件路径获取文件名称
	 *
	 * @param path path
	 * @return
	 */
	private List<String> getFileNames(String path) {
		File file = new File(path);
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