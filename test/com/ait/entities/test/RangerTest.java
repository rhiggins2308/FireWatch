package com.ait.entities.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.entities.Ranger;

class RangerTest {

	private Ranger ranger;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("In setup");
		ranger = new Ranger(true, "John Doe", "0871234567", "JDoe@test.com", "Sydney", "North-West");
	}

	@Test
	void testRangerConstructor() {
		System.out.println("Testing ranger constructor");
		assertEquals(true, ranger.isStatus());
		assertEquals("John Doe", ranger.getFullName());
		assertEquals("0871234567", ranger.getPhoneNumber());
		assertEquals("JDoe@test.com", ranger.getEmailAddress());
		assertEquals("Sydney", ranger.getLocation());
		assertEquals("North-West", ranger.getDirection());
	}

	@Test
	void testIsStatus() {
		assertEquals(true, ranger.isStatus());
	}

	@Test
	void testSetStatus() {
		ranger.setStatus(false);
		assertEquals(false, ranger.isStatus());
	}

	@Test
	void testGetFullName() {
		assertEquals("John Doe", ranger.getFullName());
	}

	@Test
	void testSetFullName() {
		ranger.setFullName("Jane Doe");
		assertEquals("Jane Doe", ranger.getFullName());
	}

	@Test
	void testGetPhoneNumber() {
		assertEquals("0871234567", ranger.getPhoneNumber());
	}

	@Test
	void testSetPhoneNumber() {
		ranger.setPhoneNumber("0861234567");
		assertEquals("0861234567", ranger.getPhoneNumber());
	}

	@Test
	void testGetEmailAddress() {
		assertEquals("JDoe@test.com", ranger.getEmailAddress());
	}

	@Test
	void testSetEmailAddress() {
		ranger.setEmailAddress("JDoe@test.co.uk");
		assertEquals("JDoe@test.co.uk", ranger.getEmailAddress());
	}

	@Test
	void testGetLocation() {
		assertEquals("Sydney", ranger.getLocation());
	}

	@Test
	void testSetLocation() {
		ranger.setLocation("Melbourne");
		assertEquals("Melbourne", ranger.getLocation());
	}

	@Test
	void testGetDirection() {
		assertEquals("North-West", ranger.getDirection());
	}

	@Test
	void testSetDirection() {
		ranger.setDirection("South-East");
		assertEquals("South-East", ranger.getDirection());
	}

	@Test
	void testChangeEditable() {
		ranger.setEditable(true);
		assertTrue(ranger.isEditable());
	}

}
