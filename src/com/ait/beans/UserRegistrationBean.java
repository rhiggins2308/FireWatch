package com.ait.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.entities.User;

@ManagedBean
@SessionScoped
public class UserRegistrationBean implements Serializable {

	private static final long serialVersionUID = 5932004350636146849L;

	private String fullName;
	private String address;
	private String mobile;
	private String username;
	private String password;
	private String passwordC;
	private boolean isStaff;

	@ManagedProperty(value = "#{appStorageBean}")
	private AppStorageBean appStorageBean;

	public String addUser() {
		FacesContext context = FacesContext.getCurrentInstance();

		for (User userCheck : appStorageBean.getUsers()) {
			if (username.equals(userCheck.getUsername())) {
				context.addMessage("userexists",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Username already exists"));
				return null;
			} else if (mobile.equals(userCheck.getMobile())) {
				context.addMessage("phoneexists",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Phone number already exists"));
				return null;
			}
		}
		if (this.password.equals(this.passwordC)) {
			final User user = new User(this.fullName, this.address, this.mobile, this.username, this.password,
					this.isStaff);

			appStorageBean.addNewUser(user);
			fullName = null;
			address = null;
			mobile = null;
			username = null;
			password = null;
			passwordC = null;
			context.addMessage(null, new FacesMessage("Account successfully created"));
			context.addMessage(null, new FacesMessage("Please log in with your credentials!"));
			return "login.jsf";
		} else {
			context.addMessage("passwordmismatch",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Passwords do not match!"));
		}
		return null;
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

	public String getPasswordC() {
		return passwordC;
	}

	public void setPasswordC(String passwordC) {
		this.passwordC = passwordC;
	}

	public void setStaff(boolean isStaff) {
		this.isStaff = isStaff;
	}

	public boolean getStaff() {
		return isStaff;
	}

	public void setAppStorageBean(AppStorageBean appStorageBean) {
		this.appStorageBean = appStorageBean;
	}

	public AppStorageBean getAppStorageBean() {
		return appStorageBean;
	}
}
