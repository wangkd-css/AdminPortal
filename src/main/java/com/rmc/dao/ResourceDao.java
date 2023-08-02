package com.rmc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.rmc.model.ResourceModel;


@Mapper
//@Component
public interface ResourceDao {

public int addResource(ResourceModel Resource);

public List<ResourceModel> getResourceList();

public int deleteResource(@Param("resourceID") String ResourceID);

public List<ResourceModel> getResource(@Param("resourceID") String ResourceID);

public int updateResource(ResourceModel Resource);


}

