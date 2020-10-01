package com.ait.beans.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.beans.AppStorageBean;
import com.ait.beans.ForestBean;
import com.ait.beans.UserLoginBean;

class ForestBeanTest {

	private AppStorageBean appStorageBean;
	private UserLoginBean userLoginBean;
	private ForestBean forestBean;

	@BeforeEach
	void setUp() throws Exception {
		appStorageBean = new AppStorageBean();
		userLoginBean = new UserLoginBean();
		forestBean = new ForestBean();
	}

	@Test
	void testChangeName() {
		forestBean.setName("erkwood");
		assertEquals("erkwood", forestBean.getName());
	}

	@Test
	void testChangeState() {
		forestBean.setState("Queensland");
		assertEquals("Queensland", forestBean.getState());
	}

	@Test
	void testChangeDirection() {
		forestBean.setDirection("South");
		assertEquals("South", forestBean.getDirection());
	}

	@Test
	void testChangeSurface() {
		forestBean.setSurface("muddy");
		assertEquals("muddy", forestBean.getSurface());
	}

	@Test
	void testCancel() {
		assertEquals("forests-table.jsf", forestBean.cancel());
	}

	@Test
	void testChangeAppStorageBean() {
		forestBean.setAppStorageBean(appStorageBean);
		assertEquals(appStorageBean, forestBean.getAppStorageBean());
	}

	@Test
	void testChangeUserLoginBean() {
		forestBean.setUserLoginBean(userLoginBean);
		assertEquals(userLoginBean, forestBean.getUserLoginBean());
	}

}
