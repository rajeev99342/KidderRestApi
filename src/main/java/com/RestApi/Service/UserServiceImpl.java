package com.RestApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestApi.Dao.UserDao;
import com.RestApi.Model.UserModel;
@Service
public class UserServiceImpl implements UserService{
	UserDao userDao;
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public String saveUserDetail(UserModel userModel) {
		return userDao.saveUserDetail(userModel);
		
	}
	

}
