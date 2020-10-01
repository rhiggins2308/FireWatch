package com.ait.beans.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.beans.AppStorageBean;
import com.ait.beans.UserRegistrationBean;

class UserRegistrationBeanTest {

	private UserRegistrationBean userRegistrationBean;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("In setup");
		userRegistrationBean = new UserRegistrationBean();
	}

	@Test
	void testGetSetFullName() {
		System.out.println("Testing testGetFullName()");
		userRegistrationBean.setFullName("Paddy Casey");
		assertEquals("Paddy Casey", userRegistrationBean.getFullName());
	}

	@Test
	void testGetSetAddress() {
		System.out.println("Testing testSetAddress()");
		userRegistrationBean.setAddress("Carrigmore Manor 25, Dublin");
		assertEquals("Carrigmore Manor 25, Dublin", userRegistrationBean.getAddress());
	}

	@Test
	void testGetSetMobile() {
		System.out.println("Testing testSetMobile()");
		userRegistrationBean.setMobile("087 123 6574");
		assertEquals("087 123 6574", userRegistrationBean.getMobile());
	}

	@Test
	void testGetSetUsername() {
		System.out.println("Testing testSetUsername()");
		userRegistrationBean.setUsername("PaddyC");
		assertEquals("PaddyC", userRegistrationBean.getUsername());
	}

	@Test
	void testGetSetPassword() {
		System.out.println("Testing testSetPassword()");
		userRegistrationBean.setPassword("PaddyGuy");
		assertEquals("PaddyGuy", userRegistrationBean.getPassword());
	}

	@Test
	void testGetSetPasswordC() {
		System.out.println("Testing testSetPasswordC()");
		userRegistrationBean.setPasswordC("PaddyGuy");
		assertEquals("PaddyGuy", userRegistrationBean.getPasswordC());
	}

	@Test
	void testgetSetStaff() {
		System.out.println("Testing testGetSetStaff()");
		userRegistrationBean.setStaff(true);
		assertEquals(true, userRegistrationBean.getStaff());
	}

	@Test
	void testSetAppStorageBean() {
		System.out.println("Testing testSetAppStorageBean()");
		AppStorageBean a = new AppStorageBean();
		userRegistrationBean.setAppStorageBean(a);
		assertEquals(userRegistrationBean.getAppStorageBean(), a);
	}

}
