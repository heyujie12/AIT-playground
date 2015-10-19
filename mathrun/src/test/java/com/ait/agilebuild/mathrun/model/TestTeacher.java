package com.ait.agilebuild.mathrun.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestTeacher {
	@Test
	public void testSingletonGetInstance() {
		Teacher t = new Teacher();
		assertNotNull(t);
	}
}
