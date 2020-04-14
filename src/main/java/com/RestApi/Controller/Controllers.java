package com.RestApi.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.RestApi.Dao.UserDao;
import com.RestApi.DaoImpl.ClassesDaoImpl;
import com.RestApi.DaoImpl.SubjectsDaoImpl;
import com.RestApi.DaoImpl.UserDaoImpl;
import com.RestApi.Model.UserModel;
import com.google.gson.Gson;
@CrossOrigin(origins = "*", allowedHeaders = "*")

@Controller
@RequestMapping("/kidder/main")
public class Controllers {
	@Autowired
	ClassesDaoImpl classesDaoImpl;
	@Autowired
	SubjectsDaoImpl subjectDaoImpl;
//	@Autowired
//	UserDaoImpl userDaoImpl;
//	
	
	@RequestMapping(value = "/classAndSubjects", method = RequestMethod.GET)
	public @ResponseBody HashMap<String,List<Object>> getClassAndSubjects() {
		HashMap<String, List<Object>> map = new HashMap<String, List<Object>>();
		map.put("CLASSLIST", new ArrayList<Object>(classesDaoImpl.allClassList()));
		map.put("SUBJECTLIST", new ArrayList<Object>(subjectDaoImpl.allSubjectList()));
		return map;
	}
	
	
	@RequestMapping(value = "/saveUserData", method = RequestMethod.POST)
	public @ResponseBody UserModel saveUserData(@ModelAttribute UserModel userModel) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.saveUserDetail(userModel);
		return null;
	}
	
}

