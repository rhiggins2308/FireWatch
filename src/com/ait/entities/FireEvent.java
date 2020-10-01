package com.ait.entities;

import java.util.Date;

public class FireEvent {

	private String state;
	private String direction;
	private Date reportedDate;
	private boolean active;
	private String description;
	private User reportedBy;
	boolean canEdit;
	private Ranger ranger;

	public FireEvent(String state, String direction, Date reportedDate, String description, User reportedBy) {
		super();
		this.state = state;
		this.direction = direction;
		this.reportedDate = reportedDate;
		this.description = description;
		this.reportedBy = reportedBy;
		this.active = true;
	}

	public Ranger getRanger() {
		return this.ranger;
	}

	public void setRanger(Ranger ranger) {
		this.ranger = ranger;
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

	public Date getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getReportedBy() {
		return reportedBy;
	}

	public void setReportedBy(User reportedBy) {
		this.reportedBy = reportedBy;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isCanEdit() {
		return canEdit;
	}

	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}

}
