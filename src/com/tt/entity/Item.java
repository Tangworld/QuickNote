package com.tt.entity;

public class Item {

	/*username,password,editText2.getText().toString(),
	latitude,longitude*/
	private String username;
	private String password;
	private String content;
	private String latitude;
	private String longitude;
	public Item(){
		
	}
	
	public Item(String username, String password, String content,
			String latitude, String longitude) {
		super();
		this.username = username;
		this.password = password;
		this.content = content;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
}
