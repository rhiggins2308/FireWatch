package com.ait.entities;

public class User {

	private String fullName;
	private String address;
	private String mobile;
	private String username;
	private String password;
	private boolean isStaff;

	public User(String fullName, String address, String mobile, String username, String password, boolean isStaff) {

		this.fullName = fullName;
		this.address = address;
		this.mobile = mobile;
		this.username = username;
		this.password = password;
		this.isStaff = isStaff;

	}

	public boolean isStaff() {
		return isStaff;
	}

	public void setStaff(boolean isStaff) {
		this.isStaff = isStaff;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

}
