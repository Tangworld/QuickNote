package com.tt.entity;

public class Fc {
	private String name;
	private String content;
	private String user;
	
	public Fc(String name,String content,String user){
		this.name=name;
		this.content=content;
		this.user=user;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getContent() {
		return content;
	}

	public void setContext(String content) {
		this.content = content;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}
	
	
}
