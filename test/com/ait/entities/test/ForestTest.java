package com.ait.entities.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.entities.Forest;

class ForestTest {

	private Forest forest;

	@BeforeEach
	void setUp() throws Exception {
		forest = new Forest("Reynolds", "Sydney", "North-West", "Dense with hills");
	}

	@Test
	void testForest() {
		assertEquals("Reynolds", forest.getName());
		assertEquals("Sydney", forest.getState());
		assertEquals("North-West", forest.getDirection());
		assertEquals("Dense with hills", forest.getSurface());
	}

	@Test
	void testGetName() {
		assertEquals("Reynolds", forest.getName());
	}

	@Test
	void testSetName() {
		forest.setName("Blackwood");
		assertEquals("Blackwood", forest.getName());
	}

	@Test
	void testGetState() {
		assertEquals("Sydney", forest.getState());
	}

	@Test
	void testSetState() {
		forest.setState("Dublin");
		assertEquals("Dublin", forest.getState());
	}

	@Test
	void testGetLocation() {
		assertEquals("North-West", forest.getDirection());
	}

	@Test
	void testSetDirection() {
		forest.setDirection("North-East");
		assertEquals("North-East", forest.getDirection());
	}

	@Test
	void testGetSurface() {
		assertEquals("Dense with hills", forest.getSurface());
	}

	@Test
	void testSetSurface() {
		forest.setSurface("Dense without hills");
		assertEquals("Dense without hills", forest.getSurface());
	}

	@Test
	void testGetStatus() {
		assertFalse(forest.isStatus());
	}

	@Test
	void testSetStatus() {
		forest.setStatus(true);
		assertTrue(forest.isStatus());
	}

}
