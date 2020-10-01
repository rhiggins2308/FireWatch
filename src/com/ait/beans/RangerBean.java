package com.ait.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.entities.FireEvent;
import com.ait.entities.Ranger;

@ManagedBean
@SessionScoped
public class RangerBean implements Serializable {

	private static final long serialVersionUID = 2066157466836902889L;

	private String fullName;
	private String phoneNumber;
	private String emailAddress;
	private String state;
	private String direction;

	private boolean noRangers = false;

	@ManagedProperty(value = "#{appStorageBean}")
	private AppStorageBean appStorageBean;

	@ManagedProperty(value = "#{fireEventBean}")
	private FireEventBean fireEventBean;

	private ArrayList<Ranger> availableRangers;

	public String addRanger() {
		FacesContext context = FacesContext.getCurrentInstance();
		final Ranger ranger = new Ranger(true, this.fullName, this.phoneNumber, this.emailAddress, this.state,
				this.direction);
		appStorageBean.addNewRanger(ranger);
		fullName = null;
		phoneNumber = null;
		emailAddress = null;
		state = null;
		direction = null;
		context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("A new ranger has been added in the list!"));
		return "rangers-table.jsf";
	}

	public ArrayList<Ranger> getAvailableRangers() {
		availableRangers = new ArrayList<Ranger>();
		for (Ranger ranger : appStorageBean.getRangers()) {
			if (ranger.isStatus() == true) {
				availableRangers.add(ranger);
			}
		}
		return availableRangers;
	}

	public void noRangersAvailable() {
		int notAvailable = 0;
		for (Ranger ranger : appStorageBean.getRangers()) {
			if (ranger.isStatus() == false) {
				notAvailable++;
			}
		}
		if (notAvailable == appStorageBean.getRangers().size()) {
			noRangers = true;
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "No available rangers"));
		} else {
			noRangers = false;
		}
	}

	public String numberOfUnassignedEvents() {
		int count = 0;
		for (FireEvent event : fireEventBean.getActiveFireEvents()) {
			if (event.getRanger() == null) {
				count++;
			}
		}
		return count
				+ " fire event(s) unassigned!\nPlease resolve fire events that no longer need attention or add new rangers";

	}

	public String saveRanger(Ranger ranger) {
		ranger.setEditable(false);
		return null;
	}

	public String editRanger(Ranger ranger) {
		ranger.setEditable(true);
		return null;
	}

	public String cancel() {
		return "rangers-table.jsf";
	}

	public AppStorageBean getAppStorageBean() {
		return appStorageBean;
	}

	public void setAppStorageBean(AppStorageBean appStorageBean) {
		this.appStorageBean = appStorageBean;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public boolean isNoRangers() {
		return noRangers;
	}

	public void setNoRangers(boolean noRangers) {
		this.noRangers = noRangers;
	}

	public FireEventBean getFireEventBean() {
		return fireEventBean;
	}

	public void setFireEventBean(FireEventBean fireEventBean) {
		this.fireEventBean = fireEventBean;
	}
}
