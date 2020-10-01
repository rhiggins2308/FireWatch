package com.ait.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.entities.FireEvent;
import com.ait.entities.Ranger;
import com.ait.entities.User;

@ManagedBean
@SessionScoped
public class FireEventBean implements Serializable {

	private static final long serialVersionUID = -713137081010164527L;
	private String description;
	private Ranger ranger;
	private String state;
	private String direction;

	@ManagedProperty(value = "#{appStorageBean}")
	private AppStorageBean appStorageBean;

	@ManagedProperty(value = "#{userLoginBean}")
	private UserLoginBean userLoginBean;

	private FireEvent selectedFireEvent;

	// this will hold the active fire events only
	private ArrayList<FireEvent> activeFireEvents;

	public String addFireEvent() {
		Date date = new Date();
		User currentUser = userLoginBean.getLoginAttempt();
		final FireEvent newFireEvent = new FireEvent(this.state, this.direction, date, this.description, currentUser);
		appStorageBean.addNewFireEvent(newFireEvent);
		description = null;
		ranger = null;
		state = null;
		direction = null;

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(null, "Thank you for reporting the fire event!"));
		if (userLoginBean.getLoginAttempt().isStaff() == true) {
			return "staff-dash.jsf";
		} else {
			return "user-fire-events.jsf";
		}
	}

	public ArrayList<FireEvent> getActiveFireEvents() {
		activeFireEvents = new ArrayList<FireEvent>();
		for (FireEvent event : appStorageBean.getFireEvents()) {
			if (event.isActive()) {
				activeFireEvents.add(event);
			}
		}
		return activeFireEvents;
	}

	public String viewFireDetails(FireEvent fireEvent) {
		this.selectedFireEvent = fireEvent;
		return "fire-details.jsf";
	}

	public String cancel() {
		if (userLoginBean.getLoginAttempt().isStaff()) {
			return "staff-dash.jsf";
		} else {
			return "user-fire-events.jsf";
		}
	}

	public void setActiveFireEvents(ArrayList<FireEvent> activeFireEvents) {
		this.activeFireEvents = activeFireEvents;
	}

	public AppStorageBean getAppStorageBean() {
		return appStorageBean;
	}

	public void setAppStorageBean(AppStorageBean appStorageBean) {
		this.appStorageBean = appStorageBean;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public FireEvent getSelectedFireEvent() {
		return selectedFireEvent;
	}

	public void setSelectedFireEvent(FireEvent selectedFireEvent) {
		this.selectedFireEvent = selectedFireEvent;
	}

	public UserLoginBean getUserLoginBean() {
		return userLoginBean;
	}

	public void setUserLoginBean(UserLoginBean userLoginBean) {
		this.userLoginBean = userLoginBean;
	}

	public Ranger getRanger() {
		return ranger;
	}

	public String setRanger(Ranger ranger) {
		this.ranger = ranger;
		return "index.jsf";
	}

}
