package com.RestApi.Model;

import java.io.Serializable;

public class Classes implements Serializable {
	private static final long serialVersionUID = 10001L;
	private int class_id;
	private String class_name;
	private String class_code;
	private String class_board_name;
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_code() {
		return class_code;
	}
	public void setClass_code(String class_code) {
		this.class_code = class_code;
	}
	public String getClass_board_name() {
		return class_board_name;
	}
	public void setClass_board_name(String class_board_name) {
		this.class_board_name = class_board_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
