package com.RestApi.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.RestApi.Dao.GroupDao;
import com.RestApi.Model.GroupModel;

public class GroupServiceImpl implements GroupService{
	GroupDao groupDao;
	@Autowired
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}
	public void saveUserDetail(GroupModel groupModel) {
		groupDao.saveGroupDetail(groupModel);
		
	}

}
