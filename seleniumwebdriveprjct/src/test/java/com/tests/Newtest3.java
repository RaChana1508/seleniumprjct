package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Newtest3 {
	@Test
	public void testassertion()
	{
		SoftAssert sa=new SoftAssert();
		String actual="Rachana";
		String expected ="rachana";
		System.out.println("check1");
		sa.assertEquals(actual, expected);
		sa.assertTrue(5>3);
		System.out.println("check2");
		sa.assertAll();

}

}
