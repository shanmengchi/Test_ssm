package com.shan.pojo;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5874523766417402732L;
	private String id;
	private String name;
	private String grade;
	private char sex;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public Person() {
		super();
	}
	public Person(String id, String name, String grade, char sex) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.sex = sex;
	}
	public Person( String name, String grade, char sex) {
		super();
		this.name = name;
		this.grade = grade;
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", grade=" + grade + ", sex=" + sex + "]";
	}
	
	
}
