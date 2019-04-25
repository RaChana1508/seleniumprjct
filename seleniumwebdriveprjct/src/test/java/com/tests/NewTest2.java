package com.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest2 {
  @Test
  public void test1() {
	  System.out.println("in test1");
  }
  @Test
  public void test2()
  {
	  System.out.println("test2");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("before");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after");
  }
  @BeforeClass
  public void beforeclass()
  {
	  System.out.println("before class");
  }
  @AfterClass
  public void afterclass()
  {
	  System.out.println("after class");
  }
  @BeforeTest
  public void beforeTest()
  {
	  System.out.println("before test");
  }
  @AfterTest
  public void afterTest()
  {
	  System.out.println("after test");
  }
  

}
