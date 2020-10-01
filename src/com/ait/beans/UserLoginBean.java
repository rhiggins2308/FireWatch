package com.ait.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.ait.entities.User;

@ManagedBean
@SessionScoped
public class UserLoginBean implements Serializable {

	private static final long serialVersionUID = -1095461582989688L;

	private String username;
	private String password;
	private boolean userVerified;
	private User LoginAttempt;

	@ManagedProperty(value = "#{appStorageBean}")
	private AppStorageBean appStorageBean;

	public void login() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

		LoginAttempt = new User("", "", "", this.username, this.password, false);

		for (User user : appStorageBean.getUsers()) {
			if (LoginAttempt.getUsername().equals(user.getUsername())
					&& LoginAttempt.getPassword().equals(user.getPassword())) {
				userVerified = true;
				LoginAttempt = user;
				break;
			}
			userVerified = false;
		}
		if (userVerified == true) {
			if (LoginAttempt.isStaff() == true) {
				context.addMessage(null, new FacesMessage("Staff Logged in!!"));
				context.getExternalContext().redirect("staff-dash.jsf");
				this.username = null;
				this.password = null;
			} else if (LoginAttempt.isStaff() == false) {
				context.addMessage(null, new FacesMessage("User Logged in!!"));
				context.getExternalContext().redirect("user-fire-events.jsf");
				this.username = null;
				this.password = null;
			}
		} else if (userVerified == false) {
			context.addMessage("loginfail1", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Login failed"));
			context.addMessage("loginfail2",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Incorrect username/password"));
			this.username = null;
			this.password = null;
		}
	}

	public void validation() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		if (userVerified == false) {
			context.getExternalContext().invalidateSession();
			context.getExternalContext().redirect("login.jsf");
		}

	}

	public void logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.username = null;
			this.password = null;
			userVerified = false;
			context.getExternalContext().getSession(false);
			context.getExternalContext().invalidateSession();
			context.getExternalContext().redirect("login.jsf");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
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

	public void setAppStorageBean(AppStorageBean appStorageBean) {
		this.appStorageBean = appStorageBean;
	}

	public AppStorageBean getAppStorageBean() {
		return appStorageBean;
	}

	public User getLoginAttempt() {
		return LoginAttempt;
	}

	public void setLoginAttempt(User loginAttempt) {
		LoginAttempt = loginAttempt;
	}

}
