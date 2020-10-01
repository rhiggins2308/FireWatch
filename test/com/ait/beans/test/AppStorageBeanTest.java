package com.ait.beans.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.beans.AppStorageBean;
import com.ait.entities.FireEvent;
import com.ait.entities.Forest;
import com.ait.entities.Ranger;
import com.ait.entities.User;

class AppStorageBeanTest {

	private AppStorageBean appStorageBean;

	@BeforeEach
	void setUp() throws Exception {
		appStorageBean = new AppStorageBean();
	}

	@Test
	void testInit() {
		appStorageBean.init();
	}

	@Test
	void testChangeState() {
		ArrayList<String> states = new ArrayList<String>();
		appStorageBean.setStates(states);
		assertEquals(states, appStorageBean.getStates());
	}

	@Test
	void testChangeDirection() {
		ArrayList<String> directions = new ArrayList<String>();
		appStorageBean.setDirections(directions);
		assertEquals(directions, appStorageBean.getDirections());
	}

	@Test
	void testAddNewUser() {
		User user = new User("John Smith", "Pleasant view 5, Gotham City", "086 654 4567", "JSmith", "JohnyBoy", false);
		appStorageBean.addNewUser(user);
		assertNotNull(appStorageBean.getUsers());
	}

	@Test
	void testAddNewRanger() {
		Ranger ranger = new Ranger(true, "John Doe", "0871234567", "JDoe@test.com", "Sydney", "North-West");
		appStorageBean.addNewRanger(ranger);
		assertNotNull(appStorageBean.getRangers());
	}

	@Test
	void testAddNewForest() {
		Forest forest = new Forest("Reynolds", "Sydney", "North-West", "Dense with hills");
		appStorageBean.addNewForest(forest);
		assertNotNull(appStorageBean.getForests());
	}

	@Test
	void testChangeUsers() {
		ArrayList<User> users = new ArrayList<User>();
		appStorageBean.setUsers(users);
		assertEquals(users, appStorageBean.getUsers());
	}

	@Test
	void testChangeRangers() {
		ArrayList<Ranger> rangers = new ArrayList<Ranger>();
		appStorageBean.setRangers(rangers);
		assertEquals(rangers, appStorageBean.getRangers());
	}

	@Test
	void testChangeFireEvents() {
		ArrayList<FireEvent> fireEvents = new ArrayList<FireEvent>();
		appStorageBean.setFireEvents(fireEvents);
		assertEquals(fireEvents, appStorageBean.getFireEvents());
	}

	@Test
	void testChangeForests() {
		ArrayList<Forest> forests = new ArrayList<Forest>();
		appStorageBean.setForests(forests);
		assertEquals(forests, appStorageBean.getForests());
	}

	@Test
	void testEditandResolveFire() {
		User user = new User("fullName", "address", "123", "username", "password", true);
		Date date = new Date();
		Ranger ranger = new Ranger(true, "John Doe", "0871234567", "JDoe@test.com", "Sydney", "North-West");
		FireEvent fireEvent = new FireEvent("Victoria", "North", date, "Bad", user);
		fireEvent.setRanger(ranger);
		assertEquals(null,appStorageBean.editFire(fireEvent));
		appStorageBean.resolveFire(fireEvent);

	}

	@Test
	void testSaveAction() {
		ArrayList<FireEvent> fireEvents = new ArrayList<FireEvent>();
		User user = new User("fullName", "address", "123", "username", "password", true);
		Date date = new Date();
		FireEvent fireEvent = new FireEvent("Victoria", "North", date, "Bad", user);
		fireEvents.add(fireEvent);
		appStorageBean.setFireEvents(fireEvents);
		assertNull(appStorageBean.saveAction());
	}

	@Test
	void testEditSaveDeleteForest() {
		Forest forest = new Forest("Reynolds", "Sydney", "North-West", "Dense with hills");
		assertNull(appStorageBean.editForest(forest));
		appStorageBean.saveForest(forest);
		assertNull(appStorageBean.deleteForest(forest));
	}

	@Test
	void testDeleteRanger() {
		Ranger ranger = new Ranger(true, "John Doe", "0871234567", "JDoe@test.com", "Sydney", "North-West");
		assertNull(appStorageBean.deleteRanger(ranger));
	}

	@Test
	void testGetDirections() {
		assertEquals("North", appStorageBean.getN());
		assertEquals("North-West", appStorageBean.getNW());
		assertEquals("North-East", appStorageBean.getNE());
		assertEquals("East", appStorageBean.getE());
		assertEquals("South-East", appStorageBean.getSE());
		assertEquals("West", appStorageBean.getW());
		assertEquals("South-West", appStorageBean.getSW());
		assertEquals("South", appStorageBean.getS());
	}

	@Test
	void testGetStates() {
		assertEquals("Western Australia", appStorageBean.getWESTERN_AUSTRALIA());
		assertEquals("Northern Territory", appStorageBean.getNORTHERN_TERRITORY());
		assertEquals("South Australia", appStorageBean.getSOUTH_AUSTRALIA());
		assertEquals("Queensland", appStorageBean.getQUEENSLAND());
		assertEquals("New South Wales", appStorageBean.getNEW_SOUTH_WALES());
		assertEquals("Victoria", appStorageBean.getVICTORIA());
		assertEquals("Tasmania", appStorageBean.getTASMANIA());

	}

}
