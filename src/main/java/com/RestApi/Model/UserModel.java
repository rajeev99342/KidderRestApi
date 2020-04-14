package com.RestApi.Model;

import java.io.Serializable;

public class UserModel implements Serializable {
	private static final long serialVersionUID = 10002L;
   private int user_id;
   private String  user_name;
   private String  user_username;
   private String  user_password;
   private String  user_email ;
   private String  user_website;
   private Integer  user_referal_threshold;
   private String  user_institute;
   private String   user_address;
   private Integer  user_type ;
   private String  user_refer_code;
   private String  user_refer_from;
   private boolean   user_isCompetator;
   private String   user_unique_code;
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getUser_username() {
	return user_username;
}
public void setUser_username(String user_username) {
	this.user_username = user_username;
}
public String getUser_password() {
	return user_password;
}
public void setUser_password(String user_password) {
	this.user_password = user_password;
}
public String getUser_email() {
	return user_email;
}
public void setUser_email(String user_email) {
	this.user_email = user_email;
}
public String getUser_website() {
	return user_website;
}
public void setUser_website(String user_website) {
	this.user_website = user_website;
}
public Integer getUser_referal_threshold() {
	return user_referal_threshold;
}
public void setUser_referal_threshold(Integer user_referal_threshold) {
	this.user_referal_threshold = user_referal_threshold;
}
public String getUser_institute() {
	return user_institute;
}
public void setUser_institute(String user_institute) {
	this.user_institute = user_institute;
}
public String getUser_address() {
	return user_address;
}
public void setUser_address(String user_address) {
	this.user_address = user_address;
}
public Integer getUser_type() {
	return user_type;
}
public void setUser_type(Integer user_type) {
	this.user_type = user_type;
}
public String getUser_refer_code() {
	return user_refer_code;
}
public void setUser_refer_code(String user_refer_code) {
	this.user_refer_code = user_refer_code;
}
public String getUser_refer_from() {
	return user_refer_from;
}
public void setUser_refer_from(String user_refer_from) {
	this.user_refer_from = user_refer_from;
}
public boolean getUser_isCompetator() {
	return user_isCompetator;
}
public void setUser_isCompetator(boolean b) {
	this.user_isCompetator = b;
}
public String getUser_unique_code() {
	return user_unique_code;
}
public void setUser_unique_code(String user_unique_code) {
	this.user_unique_code = user_unique_code;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
   
   
   
}
