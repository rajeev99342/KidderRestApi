package com.RestApi.Dao;

import java.util.List;

import com.RestApi.Model.UserQuestionModel;

public interface UserQuestionDao {
	public List<Integer> batchQuestionInsert(List<UserQuestionModel> userQuestionModel);
}
