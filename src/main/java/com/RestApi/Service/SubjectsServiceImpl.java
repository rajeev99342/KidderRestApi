package com.RestApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestApi.Dao.SubjectsDao;
import com.RestApi.Model.Subjects;
@Service
public class SubjectsServiceImpl implements SubjectsService{
	SubjectsDao subjectDao;
	@Autowired
	public void setSubjectDao(SubjectsDao subjectDao) {
		this.subjectDao = subjectDao;
	}
	public List<Subjects> allSubjectList() {
		return subjectDao.allSubjectList();
	}
	

}
