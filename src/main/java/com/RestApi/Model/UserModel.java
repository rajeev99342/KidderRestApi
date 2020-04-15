package com.RestApi.Model;

import java.io.Serializable;

public class UserModel implements Serializable {
	private static final long serialVersionUID = 10002L;
   private int user_id;
   private String  user_name;
   private String  user_username;
   private String  user_password;
   private String  user_email ;
   private int user_phone_number;
   private String   user_unique_code;
   public int getUser_phone_number() {
	return user_phone_number;
}
public void setUser_phone_number(int user_phone_number) {
	this.user_phone_number = user_phone_number;
}

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
