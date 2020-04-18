package com.RestApi.Model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class QuizModel implements Serializable {
	private static final long serialVersionUID = 10011L;
	private int quiz_id;
	private String quiz_name;
	private String grp_name;
	private String[] quiz_exam;
	private String[] quiz_sub;
	private String[] quiz_topic;
	private Date quiz_created_date;
	private Time quiz_time;
	private int quiz_duration;
	private Double quiz_marks;
	private int quiz_num_of_ques;
	private String quiz_creator;
	private Date quiz_published_date;
	private List<UserQuestionModel> user_questlist;
	public List<UserQuestionModel> getUser_questlist() {
		return user_questlist;
	}
	public void setUser_questlist(List<UserQuestionModel> user_questlist) {
		this.user_questlist = user_questlist;
	}
	private List<Integer> quest_ids_list;
	
	public Date getQuiz_published_date() {
		return quiz_published_date;
	}
	public void setQuiz_published_date(Date quiz_published_date) {
		this.quiz_published_date = quiz_published_date;
	}
	public Date getQuiz_created_date() {
		return quiz_created_date;
	}
	public void setQuiz_created_date(Date quiz_created_date) {
		this.quiz_created_date = quiz_created_date;
	}
	public String getQuiz_creator() {
		return quiz_creator;
	}
	public void setQuiz_creator(String quiz_creator) {
		this.quiz_creator = quiz_creator;
	}
	public int getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}
	public String getQuiz_name() {
		return quiz_name;
	}
	public void setQuiz_name(String quiz_name) {
		this.quiz_name = quiz_name;
	}
	public String getGrp_name() {
		return grp_name;
	}
	public void setGrp_name(String grp_name) {
		this.grp_name = grp_name;
	}
	public Time getQuiz_time() {
		return quiz_time;
	}
	public void setQuiz_time(Time quiz_time) {
		this.quiz_time = quiz_time;
	}
	public Double getQuiz_marks() {
		return quiz_marks;
	}
	public void setQuiz_marks(Double quiz_marks) {
		this.quiz_marks = quiz_marks;
	}
	public int getQuiz_num_of_ques() {
		return quiz_num_of_ques;
	}
	public void setQuiz_num_of_ques(int quiz_num_of_ques) {
		this.quiz_num_of_ques = quiz_num_of_ques;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Integer> getQuest_ids_list() {
		return quest_ids_list;
	}
	public void setQuest_ids_list(List<Integer> quest_ids_list) {
		this.quest_ids_list = quest_ids_list;
	}
	public int getQuiz_duration() {
		return quiz_duration;
	}
	public void setQuiz_duration(int quiz_duration) {
		this.quiz_duration = quiz_duration;
	}
	public String[] getQuiz_exam() {
		return quiz_exam;
	}
	public void setQuiz_exam(String[] quiz_exam) {
		this.quiz_exam = quiz_exam;
	}
	public String[] getQuiz_sub() {
		return quiz_sub;
	}
	public void setQuiz_sub(String[] quiz_sub) {
		this.quiz_sub = quiz_sub;
	}
	public String[] getQuiz_topic() {
		return quiz_topic;
	}
	public void setQuiz_topic(String[] quiz_topic) {
		this.quiz_topic = quiz_topic;
	}
}
