package com.RestApi.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.RestApi.Dao.UserQuestImgDao;
import com.RestApi.Model.UserQuestImgModel;

public class UserQuestImgServiceImpl implements UserQuestImgService{
	UserQuestImgDao userQuestImgDao;
	@Autowired
	public void setImageDao(UserQuestImgDao userQuestImgDao) {
		this.userQuestImgDao = userQuestImgDao;
	}
	public int insertImage(UserQuestImgModel imageModel) {
		return userQuestImgDao.insertImage(imageModel);
	}
	
}
