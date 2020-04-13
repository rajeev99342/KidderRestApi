package com.RestApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestApi.Dao.ClassesDao;
import com.RestApi.Model.Classes;
@Service
public class ClassesServiceImpl implements ClassesService{
	ClassesDao classesDao;
	@Autowired
	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}

	public List<Classes> allClassList() {
		return classesDao.allClassList();
	}

}
