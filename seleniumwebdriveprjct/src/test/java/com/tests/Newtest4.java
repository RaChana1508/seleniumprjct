package com.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Newtest4 {
	@Test(dataProvider="dp1")
	public void testDataProvider(String username,String password)
	{
		System.out.println(username+"\t\t"+password);	
	}
	@DataProvider(name="dp1")
	public Object[][] getData()
	{
		Object[][] obj= {
							{"kim","kim"},
							{"lee","lee"},
							{"park","park"}
		};
		return obj;
	}
}
