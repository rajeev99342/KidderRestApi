package com.RestApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RestApi.Dao.QuizDao;
import com.RestApi.Model.QuizModel;
@Service
public class QuizServiceImpl implements QuizService{
	QuizDao quizDao;
	@Autowired
	public void setQuizDao(QuizDao quizDao) {
		this.quizDao = quizDao;
	}
	@Transactional
	public void saveQuizDetail(QuizModel quizModel) {
		quizDao.saveQuizDetail(quizModel);
	}

}
