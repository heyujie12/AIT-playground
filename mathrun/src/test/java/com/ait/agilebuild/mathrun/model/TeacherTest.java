package com.ait.agilebuild.mathrun.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;


public class TeacherTest {

	@Test
	public void testSingletonGetInstance() {
		Teacher t = new Teacher();
		assertNotNull(t);
	}
}
