package com.ait.entities;

public class Forest {

	private String name;
	private String state;
	private String direction;
	private String surface;
	private boolean status;

	public Forest(String name, String state, String direction, String surface) {
		this.name = name;
		this.state = state;
		this.direction = direction;
		this.surface = surface;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
