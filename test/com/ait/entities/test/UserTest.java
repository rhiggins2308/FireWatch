package com.ait.entities.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.entities.User;

class UserTest {

	private User user;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("In setup");
		user = new User("John Smith", "Pleasant view 5, Gotham City", "086 654 4567", "JSmith", "JohnyBoy", false);
	}

	@Test
	void testUserConstructor() {
		System.out.println("Testing user constructor");
		assertEquals("John Smith", user.getFullName());
		assertEquals("Pleasant view 5, Gotham City", user.getAddress());
		assertEquals("086 654 4567", user.getMobile());
		assertEquals("JSmith", user.getUsername());
		assertEquals("JohnyBoy", user.getPassword());
		assertEquals(false, user.isStaff());
	}

	@Test
	void testIsStaff() {
		System.out.println("Testing testIsStaff()");
		assertEquals(false, user.isStaff());
	}

	@Test
	void testSetStaff() {
		System.out.println("Testing testSetStaff()");
		user.setStaff(true);
		assertEquals(true, user.isStaff());
	}

	@Test
	void testGetFullName() {
		System.out.println("Testing testGetFullName()");
		assertEquals("John Smith", user.getFullName());
	}

	@Test
	void testSetFullName() {
		System.out.println("Testing testSetFullName()");
		user.setFullName("Paddy Casey");
		assertEquals("Paddy Casey", user.getFullName());
	}

	@Test
	void testGetAddress() {
		System.out.println("Testing testGetAddress()");
		assertEquals("Pleasant view 5, Gotham City", user.getAddress());
	}

	@Test
	void testSetAddress() {
		System.out.println("Testing testSetAddress()");
		user.setAddress("Carrigmore Manor 25, Dublin");
		assertEquals("Carrigmore Manor 25, Dublin", user.getAddress());
	}

	@Test
	void testGetMobile() {
		System.out.println("Testing testGetMobile()");
		assertEquals("086 654 4567", user.getMobile());
	}

	@Test
	void testSetMobile() {
		System.out.println("Testing testSetMobile()");
		user.setMobile("087 123 6574");
		assertEquals("087 123 6574", user.getMobile());
	}

	@Test
	void testGetUsername() {
		System.out.println("Testing testGetUsername()");
		assertEquals("JSmith", user.getUsername());
	}

	@Test
	void testSetUsername() {
		System.out.println("Testing testSetUsername()");
		user.setUsername("PaddyC");
		assertEquals("PaddyC", user.getUsername());
	}

	@Test
	void testGetPassword() {
		System.out.println("Testing testGetPassword()");
		assertEquals("JohnyBoy", user.getPassword());
	}

	@Test
	void testSetPassword() {
		System.out.println("Testing testSetPassword()");
		user.setPassword("PaddyGuy");
		assertEquals("PaddyGuy", user.getPassword());
	}

}
