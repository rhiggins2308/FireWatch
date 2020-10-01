package com.ait.beans.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.beans.AppStorageBean;
import com.ait.beans.FireEventBean;
import com.ait.beans.RangerBean;
import com.ait.entities.FireEvent;
import com.ait.entities.Ranger;
import com.ait.entities.User;

class RangerBeanTest {

	private RangerBean rangerBean;
	private Ranger ranger;
	private AppStorageBean appStorageBean;
	private FireEventBean fireEventBean;

	@BeforeEach
	void setUp() throws Exception {
		ranger = new Ranger(true, "John Doe", "0871234567", "JDoe@test.com", "Sydney", "North-West");
		rangerBean = new RangerBean();
		appStorageBean = new AppStorageBean();
		fireEventBean = new FireEventBean();
	}

	@Test
	void testGetAvailableRangers() {
		ArrayList<Ranger> rangers = new ArrayList<Ranger>();
		rangers.add(ranger);
		appStorageBean.setRangers(rangers);
		rangerBean.setAppStorageBean(appStorageBean);
		assertEquals(1, rangerBean.getAvailableRangers().size());
	}
	
	@Test
	void testGetNoAvailableRangers() {
		ArrayList<Ranger> rangers = new ArrayList<Ranger>();
		ranger.setStatus(false);
		rangers.add(ranger);
		appStorageBean.setRangers(rangers);
		rangerBean.setAppStorageBean(appStorageBean);
		assertEquals(0, rangerBean.getAvailableRangers().size());
	}

	@Test
	void testeditRanger() {
		ranger.setEditable(false);
		assertEquals(null, rangerBean.saveRanger(ranger));
		ranger.setEditable(true);
		assertEquals(null, rangerBean.editRanger(ranger));
	}

	@Test
	void testCancel() {
		assertEquals("rangers-table.jsf", rangerBean.cancel());
	}

	@Test
	void testChangeFullName() {
		rangerBean.setFullName("John Smith");
		assertEquals("John Smith", rangerBean.getFullName());
	}

	@Test
	void testChangePhoneNumber() {
		rangerBean.setPhoneNumber("087124578");
		assertEquals("087124578", rangerBean.getPhoneNumber());
	}

	@Test
	void testChangeEmailAddress() {
		rangerBean.setEmailAddress("JSmith@test.com");
		assertEquals("JSmith@test.com", rangerBean.getEmailAddress());
	}

	@Test
	void testChangeState() {
		rangerBean.setState("Queensland");
		assertEquals("Queensland", rangerBean.getState());
	}

	@Test
	void testChangeDirection() {
		rangerBean.setDirection("South");
		assertEquals("South", rangerBean.getDirection());
	}

	@Test
	void testChangeNoRangers() {
		rangerBean.setNoRangers(true);
		assertTrue(rangerBean.isNoRangers());
	}

	@Test
	void testChangeAppStorageBean() {
		rangerBean.setAppStorageBean(appStorageBean);
		assertEquals(appStorageBean, rangerBean.getAppStorageBean());
	}

	@Test
	void testChangeFireEventBean() {
		rangerBean.setFireEventBean(fireEventBean);
		assertEquals(fireEventBean, rangerBean.getFireEventBean());
	}
	
}
