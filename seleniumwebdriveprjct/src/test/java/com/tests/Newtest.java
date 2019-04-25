package com.tests;

import org.testng.annotations.Test;

public class Newtest {
	@Test(priority=1)
	public void testGoogle()
	{
		System.out.println("in test");
	}
	@Test(priority=2)
	public void testAccenture()
	{
		System.out.println("in accenture");
	}

}
