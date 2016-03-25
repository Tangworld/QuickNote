package com.tt.entity;

public class Person {
	private String user;
	private String pwd;
	public String getUser() {
		return user;
	}
	public void setUser(String person) {
		this.user = person;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public Person(String user,String pwd){
		this.user=user;
		this.pwd=pwd;
	}
	public Person(String user){
		this.user=user;
	}
}
