package com.ait.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.ait.entities.Forest;
import com.ait.entities.FireEvent;
import com.ait.entities.Ranger;
import com.ait.entities.User;

@ManagedBean
@ApplicationScoped
public class AppStorageBean implements Serializable {

	private static final long serialVersionUID = 5686667476042421915L;

	private final String N = "North", NW = "North-West", W = "West", SW = "South-West", S = "South", SE = "South-East",
			E = "East", NE = "North-East";
	private final String WESTERN_AUSTRALIA = "Western Australia", NORTHERN_TERRITORY = "Northern Territory",
			SOUTH_AUSTRALIA = "South Australia", QUEENSLAND = "Queensland", NEW_SOUTH_WALES = "New South Wales",
			VICTORIA = "Victoria", TASMANIA = "Tasmania";

	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Ranger> rangers = new ArrayList<Ranger>();
	private ArrayList<FireEvent> fireEvents = new ArrayList<FireEvent>();
	private ArrayList<Forest> forests = new ArrayList<Forest>();
	private ArrayList<String> states = new ArrayList<String>();
	private ArrayList<String> directions = new ArrayList<String>();

	@PostConstruct
	public void init() {
		// hard-coded staff members list
		users.add(new User("Johnny", "Bravo", "0874548924", "staff", "123", true));
		users.add(new User("Robert Higgins", "Galway", "0871234567", "Rhiggins", "password", true));
		users.add(new User("Mariana Ciorba", "Not Galway", "0871345678", "Mciorba", "password", false));
		users.add(new User("Stasys Jurgaitis", "Not Galway", "0871456789", "s", "s", true));
		users.add(new User("Sean Costin", "Not Galway", "0879876543", "Scostin", "password", false));
		users.add(new User("Sean Grayson", "Not Galway", "0874848924", "Sgrayson", "password", true));

		// hardcoded states
		states.add(WESTERN_AUSTRALIA);
		states.add(NORTHERN_TERRITORY);
		states.add(SOUTH_AUSTRALIA);
		states.add(QUEENSLAND);
		states.add(NEW_SOUTH_WALES);
		states.add(VICTORIA);
		states.add(TASMANIA);

		// hardcoded directions
		directions.add(N);
		directions.add(NW);
		directions.add(W);
		directions.add(SW);
		directions.add(S);
		directions.add(SE);
		directions.add(E);
		directions.add(NE);

		// hard coded fire events
		Date date = new Date();
		fireEvents.add(new FireEvent(states.get(0), directions.get(0), new Date(), "Big Fire, Burny Hot", users.get(0)));
		fireEvents.add(new FireEvent(states.get(1), directions.get(1), date, "Not bad", users.get(1)));
		fireEvents.add(new FireEvent(states.get(2), directions.get(2), date, "I see a big flame there", users.get(2)));
		fireEvents.add(new FireEvent(states.get(3), directions.get(3), date, "Lots of animals around", users.get(3)));
		fireEvents.add(new FireEvent(states.get(4), directions.get(4), date, "The fire gets close to houses", users.get(4)));
		fireEvents.add(new FireEvent(states.get(5), directions.get(5), date, "Fire gets bigger very quick", users.get(5)));
		fireEvents.add(new FireEvent(states.get(6), directions.get(6), date, "Big Fire, Burny Hot", users.get(0)));

		// hardcoded Forests
		forests.add(new Forest("Darkwood", states.get(0), directions.get(0), "Dense with fields"));
		forests.add(new Forest("Sherwood", states.get(1), directions.get(1), "Dense with mountains"));
		forests.add(new Forest("Elkwood", states.get(2), directions.get(2), "Dense and populated"));

		addNewRanger(new Ranger(true, "John Smith", "0871234567", "JSmith@firewatch.com", "Victoria", "North-West"));
		addNewRanger(new Ranger(true, "Jane Doe", "0877891011", "JDoe@firewatch.com", "Victoria", "South-East"));
		addNewRanger(new Ranger(true, "Hugh Jackman", "0860135792", "HJackman@firewatch.com", "Queensland", "North"));
		addNewRanger(new Ranger(true, "Mick Dundee", "0851256891", "MDundee@firewatch.com", "Tasmania", "South"));
		addNewRanger(new Ranger(true, "Indiana Jones", "0851256891", "IJones@firewatch.com", "Tasmania", "West"));

	}

	public ArrayList<String> getStates() {
		return states;
	}

	public void setStates(ArrayList<String> states) {
		this.states = states;
	}

	public ArrayList<String> getDirections() {
		return directions;
	}

	public void setDirections(ArrayList<String> directions) {
		this.directions = directions;
	}

	// the users list will update when a new user is registered
	public void addNewUser(User user) {
		users.add(user);
	}

	// the rangers list will update when a new ranger is added
	public void addNewRanger(Ranger ranger) {
		rangers.add(ranger);
	}

	// the fire events list will update when a new fire event is added
	public void addNewFireEvent(FireEvent fireEvent) {
		fireEvents.add(fireEvent);
	}

	// the forests list will update when a new fire event is added
	public void addNewForest(Forest forest) {
		forests.add(forest);
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Ranger> getRangers() {
		return rangers;
	}

	public void setRangers(ArrayList<Ranger> rangers) {
		this.rangers = rangers;
	}

	public String assignRanger(FireEvent fireEvent, Ranger ranger) {
		if (fireEvent.getRanger() != null) {
			Ranger oldRanger = fireEvent.getRanger();
			oldRanger.setStatus(true);
		}
		fireEvent.setRanger(ranger);
		ranger.setStatus(false);
		System.out.println(fireEvent);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(null, "Ranger " + ranger.getFullName() + " succesfully assigned"));
		return "fire-details.jsf";
	}

	public ArrayList<FireEvent> getFireEvents() {
		return fireEvents;
	}

	public void setFireEvents(ArrayList<FireEvent> fireEvents) {
		this.fireEvents = fireEvents;
	}

	public ArrayList<Forest> getForests() {
		return forests;
	}

	public void setForests(ArrayList<Forest> forests) {
		this.forests = forests;
	}

	public String editFire(FireEvent fire) {
		fire.setCanEdit(true);
		return null;
	}

	public void resolveFire(FireEvent fire) {
		fire.setActive(false);
		if (fire.getRanger() != null) {
			fire.getRanger().setStatus(true);
		}
	}

	public String saveAction() {
		for (FireEvent fire : fireEvents) {
			fire.setCanEdit(false);
		}
		return null;
	}

	public String editForest(Forest forest) {
		forest.setStatus(true);
		return null;
	}

	public void saveForest(Forest forest) {
		forest.setStatus(false);
	}

	public String deleteForest(Forest forest) {
		forests.remove(forest);
		return null;
	}

	public String deleteRanger(Ranger ranger) {
		rangers.remove(ranger);
		return null;
	}

	public String getN() {
		return N;
	}

	public String getNW() {
		return NW;
	}

	public String getW() {
		return W;
	}

	public String getSW() {
		return SW;
	}

	public String getS() {
		return S;
	}

	public String getSE() {
		return SE;
	}

	public String getE() {
		return E;
	}

	public String getNE() {
		return NE;
	}

	public String getWESTERN_AUSTRALIA() {
		return WESTERN_AUSTRALIA;
	}

	public String getNORTHERN_TERRITORY() {
		return NORTHERN_TERRITORY;
	}

	public String getSOUTH_AUSTRALIA() {
		return SOUTH_AUSTRALIA;
	}

	public String getQUEENSLAND() {
		return QUEENSLAND;
	}

	public String getNEW_SOUTH_WALES() {
		return NEW_SOUTH_WALES;
	}

	public String getVICTORIA() {
		return VICTORIA;
	}

	public String getTASMANIA() {
		return TASMANIA;
	}

}
