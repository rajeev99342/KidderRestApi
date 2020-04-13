package com.RestApi.Model;

import java.io.Serializable;


public class Subjects implements Serializable {
	private static final long serialVersionUID = 10000L;
	private int sub_id;
	private int class_id;
	private String sub_name;
	private String sub_code;
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public String getSub_code() {
		return sub_code;
	}
	public void setSub_code(String sub_code) {
		this.sub_code = sub_code;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
