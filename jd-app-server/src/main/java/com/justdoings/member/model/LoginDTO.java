package com.justdoings.member.model;

public class LoginDTO {
	/** 信箱 */
	private String email;
	
	/** 密碼 */
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
