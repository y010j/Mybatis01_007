package com.yjj.domain;

import org.apache.ibatis.type.Alias;


public class Student {
	private int id;	//����
	private String name;	//����
	private String gender;	//�Ա�
	private String major;	//רҵ
	private String grade;	//�꼶
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
