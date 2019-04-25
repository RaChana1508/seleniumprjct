package selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Googlehomepage{
@Test
public void testGoogleHomePage() 
{
	System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\selenium\\chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.google.co.in/");
	String title = driver.getTitle();
	Assert.assertEquals(title, "Google");
	driver.close();
}
}


