package com.RestApi.Model;

public class UserQuestionModel {
	private boolean isEdit;
	private int user_quest_id;
	private String user_quest_creator;
	private int user_quest_marks;
	private String user_quest_optionA;
	private String user_quest_optionB;
	private String user_quest_optionC;
	private String user_quest_optionD;
	private String user_quest_ans;
	private String user_questtxt_model;
	private UserQuestImgModel user_quest_img_model;
	private UserQuestImgModel user_questdgrm_model;
	private int quiz_id;
	public int getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}
	public int getUser_quest_id() {
		return user_quest_id;
	}
	public void setUser_quest_id(int user_quest_id) {
		this.user_quest_id = user_quest_id;
	}
	public UserQuestImgModel getUser_questdgrm_model() {
		return user_questdgrm_model;
	}
	public void setUser_questdgrm_model(UserQuestImgModel user_questdgrm_model) {
		this.user_questdgrm_model = user_questdgrm_model;
	}
	public boolean isEdit() {
		return isEdit;
	}
	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}
	public String getUser_quest_creator() {
		return user_quest_creator;
	}
	public void setUser_quest_creator(String user_quest_creator) {
		this.user_quest_creator = user_quest_creator;
	}
	public int getUser_quest_marks() {
		return user_quest_marks;
	}
	public void setUser_quest_marks(int user_quest_marks) {
		this.user_quest_marks = user_quest_marks;
	}
	public String getUser_quest_optionA() {
		return user_quest_optionA;
	}
	public void setUser_quest_optionA(String user_quest_optionA) {
		this.user_quest_optionA = user_quest_optionA;
	}
	public String getUser_quest_optionB() {
		return user_quest_optionB;
	}
	public void setUser_quest_optionB(String user_quest_optionB) {
		this.user_quest_optionB = user_quest_optionB;
	}
	public String getUser_quest_optionC() {
		return user_quest_optionC;
	}
	public void setUser_quest_optionC(String user_quest_optionC) {
		this.user_quest_optionC = user_quest_optionC;
	}
	public String getUser_quest_optionD() {
		return user_quest_optionD;
	}
	public void setUser_quest_optionD(String user_quest_optionD) {
		this.user_quest_optionD = user_quest_optionD;
	}
	public String getUser_quest_ans() {
		return user_quest_ans;
	}
	public void setUser_quest_ans(String user_quest_ans) {
		this.user_quest_ans = user_quest_ans;
	}
	public String getUser_questtxt_model() {
		return user_questtxt_model;
	}
	public void setUser_questtxt_model(String user_questtxt_model) {
		this.user_questtxt_model = user_questtxt_model;
	}
	public UserQuestImgModel getUser_quest_img_model() {
		return user_quest_img_model;
	}
	public void setUser_quest_img_model(UserQuestImgModel user_quest_img_model) {
		this.user_quest_img_model = user_quest_img_model;
	}
}
