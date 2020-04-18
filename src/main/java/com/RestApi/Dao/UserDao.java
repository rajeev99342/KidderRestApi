package com.RestApi.Dao;

import java.util.List;

import com.RestApi.Model.UserModel;

public interface UserDao {
	public String saveUserDetail(UserModel userModel);
	public List<UserModel> getUserDetailsByUserName(String userName);
	public List<UserModel>getAllUserDetails();
}
