package com.ait.beans.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.ait.beans.AppStorageBean;
import com.ait.beans.FireEventBean;
import com.ait.beans.UserLoginBean;
import com.ait.entities.FireEvent;
import com.ait.entities.Ranger;
import com.ait.entities.User;

class FireEventBeanTest {

	private FireEvent fireEvent;
	private Date date;
	private User user;
	private UserLoginBean userLoginBean;
	private AppStorageBean appStorageBean;
	private FireEventBean bean;

	private ArrayList<FireEvent> activeFireEvents;

	@BeforeEach
	void setUp() throws Exception {
		date = new Date();
		user = new User("fullName", "address", "123", "username", "password", true);
		fireEvent = new FireEvent("Victoria", "North", date, "Bad", user);
		userLoginBean = new UserLoginBean();
		appStorageBean = new AppStorageBean();
		bean = new FireEventBean();
	}

	@Test
	void testSetActiveFireEvents() {
		appStorageBean = new AppStorageBean();
		bean.setAppStorageBean(appStorageBean);
		activeFireEvents = new ArrayList<FireEvent>();
		bean.setActiveFireEvents(activeFireEvents);
		assertEquals(activeFireEvents, bean.getActiveFireEvents());
	}

	@Test
	void testChangeDescription() {
		bean.setDescription("hello world");
		assertEquals("hello world", bean.getDescription());
	}

	@Test
	void testChangeState() {
		fireEvent.setState("Queensland");
		assertEquals("Queensland", fireEvent.getState());
		bean.setState("QueensLand");
		assertEquals("QueensLand", bean.getState());
	}

	@Test
	void testChangeDirection() {
		fireEvent.setDirection("South");
		assertEquals("South", fireEvent.getDirection());
		bean.setDirection("north");
		assertEquals("north", bean.getDirection());
	}

	@Test
	void testChangeRanger() {
		Ranger ranger = new Ranger(true, "John Doe", "0871234567", "JDoe@test.com", "Sydney", "North-West");
		bean.setRanger(ranger);
		assertEquals(ranger, bean.getRanger());
	}

	@Test
	void testDescription() {
		fireEvent.setDescription("Severe");
		assertEquals("Severe", fireEvent.getDescription());
	}

	@Test
	void testChangeUser() {
		fireEvent.setReportedBy(user);
		assertEquals("username", fireEvent.getReportedBy().getUsername());

	}

	@Test
	void testViewFireDetails() {
		assertEquals("fire-details.jsf", bean.viewFireDetails(fireEvent));
	}

	@Test
	void testAppStorageBean() {
		appStorageBean = new AppStorageBean();
		bean.setAppStorageBean(appStorageBean);
		assertEquals(appStorageBean, bean.getAppStorageBean());
	}

	@Test
	void testSelectedFireEvent() {
		bean.setSelectedFireEvent(fireEvent);
		assertEquals(fireEvent, bean.getSelectedFireEvent());
	}

	@Test
	void testUserLoginBean() {
		userLoginBean = new UserLoginBean();
		bean.setUserLoginBean(userLoginBean);
		assertEquals(userLoginBean, bean.getUserLoginBean());
	}

	@Test
	void testGetActiveFireEvents() {
		appStorageBean = new AppStorageBean();
		bean.setAppStorageBean(appStorageBean);
		FireEvent activeFireEvent = new FireEvent("Virginia", "NE", date, "Some description", user);
		FireEvent closedFireEvent = new FireEvent("Victoria", "SW", date, "Other description", user);
		closedFireEvent.setActive(false);
		appStorageBean.addNewFireEvent(activeFireEvent);
		appStorageBean.addNewFireEvent(closedFireEvent);
		ArrayList<FireEvent> actualFireEvents = bean.getActiveFireEvents();
		assertEquals(1, actualFireEvents.size());
	}

	@Test
	void testCancelStaff() {
		User staffUser = new User("fullName", "address", "123", "username", "password", true);
		userLoginBean.setLoginAttempt(staffUser);
		bean.setUserLoginBean(userLoginBean);
		String actual = bean.cancel();
		assertEquals("staff-dash.jsf", actual);
	}

	@Test
	void testCancelUser() {
		User user = new User("fullName", "address", "123", "username", "password", false);
		userLoginBean.setLoginAttempt(user);
		bean.setUserLoginBean(userLoginBean);
		String actual = bean.cancel();
		assertEquals("user-fire-events.jsf", actual);
	}
}
