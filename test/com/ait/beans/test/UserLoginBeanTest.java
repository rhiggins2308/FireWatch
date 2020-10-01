package com.ait.beans.test;

import static org.junit.jupiter.api.Assertions.*;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.SessionScoped;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.beans.AppStorageBean;
import com.ait.beans.UserLoginBean;

public class UserLoginBeanTest {

	private UserLoginBean userLoginBean;
	private AppStorageBean bean;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("In setup");
		userLoginBean = new UserLoginBean();
		bean = new AppStorageBean();
	}

	@Test
	void testGetSetUsername() {
		System.out.println("Testing testSetUsername()");
		userLoginBean.setUsername("PaddyC");
		assertEquals("PaddyC", userLoginBean.getUsername());
	}

	@Test
	void testGetSetPassword() {
		System.out.println("Testing testSetPassword()");
		userLoginBean.setPassword("PaddyGuy");
		assertEquals("PaddyGuy", userLoginBean.getPassword());
	}

	@Test
	void testChangeAppStorageBean() {
		userLoginBean.setAppStorageBean(bean);
		assertEquals(bean, userLoginBean.getAppStorageBean());
	}
}
