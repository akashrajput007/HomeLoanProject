package com.example.demo.Layer2;

public class UserLogin {
	
	private String Email_ID;
	private String Password;
	public String getEmail_ID() {
		return Email_ID;
	}
	public void setEmail_ID(String email_ID) {
		Email_ID = email_ID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "UserLogin [Email_ID=" + Email_ID + ", Password=" + Password + "]";
	}

}
