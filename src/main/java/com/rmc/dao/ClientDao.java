package com.rmc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.rmc.model.ClientModel;

@Mapper
//@Component
public interface ClientDao {

	/**
	 *
	 * @param userNames userNames 图片的用户名集合
	 * @return
	 */
	List<ClientModel> queryUserInfoByUserNames(@Param(value = "userNames") List<String> userNames);
}
