package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMeAppReg {
	WebDriver driver;
	@BeforeClass
	public void beforeClass()
	{
		driver=DriverUtility.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();
	}
	@AfterClass
	public void afterClass()
	{
		//driver.close();
	}
	@Test
	public void testMeReg()
	{
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("SignUp")));
		driver.findElement(By.partialLinkText("SignUp")).click();
		driver.findElement(By.id("userName")).sendKeys("Rachanabiyyapu");
		driver.findElement(By.xpath("//input[id='err']"));
		driver.findElement(By.id("firstName")).sendKeys("Rachana");
		driver.findElement(By.id("lastName")).sendKeys("biyyapu");
		driver.findElement(By.name("password")).sendKeys("rachu123");
		driver.findElement(By.name("confirmPassword")).sendKeys("rachu123");
		driver.findElement(By.cssSelector("input[value='Male']")).click();
		driver.findElement(By.cssSelector("input[value='Female']")).click();
		driver.findElement(By.id("emailAddress")).sendKeys("rachana123@gmail.com");
		driver.findElement(By.id("mobileNumber")).sendKeys("7396258042");
		driver.findElement(By.id("address")).sendKeys("gunjur,bangalore");
		
		
		
		
	}

}
