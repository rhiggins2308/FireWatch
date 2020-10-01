package com.ait.entities.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.entities.FireEvent;
import com.ait.entities.User;

class FireEventTest {

	private FireEvent fireEvent;
	private Date date;
	private User user;

	@BeforeEach
	void setUp() throws Exception {
		user = new User("fullName", "address", "123", "username", "password", true);
		date = new Date();
		fireEvent = new FireEvent("Victoria", "North", date, "Bad", user);
	}

	@Test
	void testConstructor() {
		assertEquals("Victoria", fireEvent.getState());
		assertEquals("North", fireEvent.getDirection());
		assertEquals(date, fireEvent.getReportedDate());
		assertEquals("Bad", fireEvent.getDescription());
		assertEquals("username", fireEvent.getReportedBy().getUsername());
	}

	@Test
	void testChangeState() {
		fireEvent.setState("Queensland");
		assertEquals("Queensland", fireEvent.getState());
	}

	@Test
	void testChangeDirection() {
		fireEvent.setDirection("South");
		assertEquals("South", fireEvent.getDirection());
	}

	@Test
	void testChangeDate() {
		fireEvent.setReportedDate(null);
		assertEquals(null, fireEvent.getReportedDate());
	}

	@Test
	void testChangeDescription() {
		fireEvent.setDescription("Severe");
		assertEquals("Severe", fireEvent.getDescription());
	}

	@Test
	void testChangeUser() {
		fireEvent.setReportedBy(user);
		assertEquals("username", fireEvent.getReportedBy().getUsername());

	}

	@Test
	void testIsActive() {
		assertEquals(true, fireEvent.isActive());
	}

	@Test
	void testChangeIsActive() {
		fireEvent.setActive(false);
		assertFalse(fireEvent.isActive());
	}

	@Test
	void testIsCanEdit() {
		assertEquals(false, fireEvent.isCanEdit());
	}

	@Test
	void testChangeIsCanEdit() {
		fireEvent.setCanEdit(true);
		assertTrue(fireEvent.isCanEdit());
	}
}