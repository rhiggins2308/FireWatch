package com.ait.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.entities.Forest;

@ManagedBean
@SessionScoped
public class ForestBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String state;
	private String direction;
	private String surface;

	@ManagedProperty(value = "#{appStorageBean}")
	private AppStorageBean appStorageBean;

	@ManagedProperty(value = "#{userLoginBean}")
	private UserLoginBean userLoginBean;

	public String addForest() {
		FacesContext context = FacesContext.getCurrentInstance();
		final Forest forest = new Forest(this.name, this.state, this.direction, this.surface);
		appStorageBean.addNewForest(forest);
		name = null;
		state = null;
		direction = null;
		surface = null;
		context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Forest Details successfully added"));
		return "forests-table.jsf";
	}

	public String cancel() {

		return "forests-table.jsf";

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public AppStorageBean getAppStorageBean() {
		return appStorageBean;
	}

	public void setAppStorageBean(AppStorageBean appStorageBean) {
		this.appStorageBean = appStorageBean;
	}

	public UserLoginBean getUserLoginBean() {
		return userLoginBean;
	}

	public void setUserLoginBean(UserLoginBean userLoginBean) {
		this.userLoginBean = userLoginBean;
	}
}
