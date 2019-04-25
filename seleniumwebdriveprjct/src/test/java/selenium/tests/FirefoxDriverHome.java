package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirefoxDriverHome {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod()
	{
		driver = DriverUtility.getDriver("chrome");
		driver.manage().window().maximize();	
	}
	@AfterMethod
	public void afterMethod()
	{
		//driver.close();

	}
	@Test(enabled=false)
	public void testGoogleHomepage()
	{
	
		driver.get("http://www.google.co.in/");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google");
		
	}
	@Test
	public void testDemoWebShop()
	{
		driver.get("http://demowebshop.tricentis.com//login");
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("webshop"));
		WebElement email= driver.findElement(By.id("Email"));
		email.sendKeys("rachana35@gmail.com");
		driver.findElement(By.id("password")).sendKeys("rachu123");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		

	}
	
}
