package com.RestApi.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.RestApi.Dao.UserDao;
import com.RestApi.Model.UserModel;

public class UserServiceImpl implements UserService{
	UserDao userDao;
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void saveUserDetail(UserModel userModel) {
		userDao.saveUserDetail(userModel);
		
	}
	

}
