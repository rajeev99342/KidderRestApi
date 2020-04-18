package com.RestApi.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.RestApi.Common.CommonResource;
import com.RestApi.DaoImpl.ClassesDaoImpl;
import com.RestApi.DaoImpl.GroupDaoImpl;
import com.RestApi.DaoImpl.QuizDaoImpl;
import com.RestApi.DaoImpl.SubjectsDaoImpl;
import com.RestApi.DaoImpl.UserDaoImpl;
import com.RestApi.Model.GroupModel;
import com.RestApi.Model.UserQuestionModel;
import com.RestApi.Model.QuizModel;
import com.RestApi.Model.UserModel;
@CrossOrigin(origins = "*", allowedHeaders = "*")

@Controller
@RequestMapping("/kidder/main")
public class Controllers {
	@Autowired
	ClassesDaoImpl classesDaoImpl;
	@Autowired
	SubjectsDaoImpl subjectDaoImpl;
	@Autowired
	UserDaoImpl userDaoImpl;
	
	
	@RequestMapping(value = "/classAndSubjects", method = RequestMethod.GET)
	public @ResponseBody HashMap<String,List<Object>> getClassAndSubjects() {
		HashMap<String, List<Object>> map = new HashMap<String, List<Object>>();
		map.put("CLASSLIST", new ArrayList<Object>(classesDaoImpl.allClassList()));
		map.put("SUBJECTLIST", new ArrayList<Object>(subjectDaoImpl.allSubjectList()));
		return map;
	}
	
	
	@RequestMapping(value = "/saveUserData", method = RequestMethod.POST)
	public @ResponseBody String saveUserData(@RequestBody UserModel userModel) throws SQLException {
		
		return userDaoImpl.saveUserDetail(userModel);
	}
	
	@Autowired
	GroupDaoImpl groupDaoImpl;
	
	@RequestMapping(value = "/saveGroupData", method = RequestMethod.POST)
	public @ResponseBody String saveGroupData(@RequestBody GroupModel groupModel) {
		return groupDaoImpl.saveGroupDetail(groupModel);
	}
	@Autowired
	QuizDaoImpl quizDaoImpl;
	@RequestMapping(value = "/saveQuiz", method = RequestMethod.POST)
	public @ResponseBody List<UserQuestionModel> saveQuizData(@RequestBody QuizModel quizModel) {
		quizDaoImpl.saveQuizDetail(quizModel);
		
		return quizModel.getUser_questlist();
	}
	
}

