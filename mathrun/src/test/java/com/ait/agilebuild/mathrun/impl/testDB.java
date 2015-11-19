package com.ait.agilebuild.mathrun.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class testDB {

	@Test
	public void test() {
		ParentDAO pa = new ParentDAO();
		pa.checkParents("aaa", "1@1.com");
	}

}
