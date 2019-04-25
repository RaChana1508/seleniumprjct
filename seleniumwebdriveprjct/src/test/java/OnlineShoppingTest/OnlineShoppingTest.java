package OnlineShoppingTest;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import selenium.tests.DriverUtility;

public class OnlineShoppingTest {

	WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports reports;
	ExtentTest logger;
	@BeforeTest
	public void startReportBeforeTest()
	{

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms");
		String path =System.getProperty("user.dir") + "/extent-reports/" + sdf.format(new Date()) + ".html";
		htmlreporter=new ExtentHtmlReporter(path);
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("username","Rachana Biyyapu");
		reports.setSystemInfo("host", "localhost");
		htmlreporter.config().setReportName("Test Me App Report");
		htmlreporter.config().setTheme(Theme.STANDARD);
		driver=DriverUtility.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}


	//=========================================================================================================================================
	@Test(priority=1)
	public void testRegistration() throws InterruptedException 
	{
		{
			driver.findElement(By.partialLinkText("SignUp")).click();
			driver.findElement(By.id("userName")).sendKeys("rachana45");
			driver.findElement(By.id("firstName")).click();
			Assert.assertEquals(driver.findElement(By.id("err")).getText(),"Available");
			logger=reports.createTest("Register");
			logger.log(Status.INFO,"Username Available");
			driver.findElement(By.id("firstName")).sendKeys("Rachana");
			driver.findElement(By.id("lastName")).sendKeys("biyyapu");
			driver.findElement(By.name("password")).sendKeys("Pass35");
			driver.findElement(By.name("confirmPassword")).sendKeys("Pass35");
			driver.findElement(By.cssSelector("input[value='Female']")).click();
			driver.findElement(By.id("emailAddress")).sendKeys("rachana12@gmail.com");
			driver.findElement(By.id("mobileNumber")).sendKeys("7396296096");
			driver.findElement(By.cssSelector("img[src='images/calendar.png']")).click();
			Select bdaymnth = new Select(driver.findElement(By.className("ui-datepicker-month")));
			bdaymnth.selectByVisibleText("Oct");
			Select bdayyear = new Select(driver.findElement(By.className("ui-datepicker-year")));
			bdayyear.selectByVisibleText("1997");
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[5]/a")).click();
			driver.findElement(By.id("address")).sendKeys("gunjur,bangalore");
			driver.findElement(By.id("securityQuestion")).click();
			driver.findElement(By.id("answer")).sendKeys("blue");
			driver.findElement(By.cssSelector("input[value='Register']")).click();
			Thread.sleep(3000);
			Assert.assertTrue(driver.findElement(By.xpath("//form[@role='form']/fieldset/div[8]")).getText().contains("User"));

		}
	}

	//========================================================================================================================================	
	@Test(priority=2)
	public void testLogin()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Login"));
		driver.findElement(By.id("userName")).sendKeys("Rachana45");
		driver.findElement(By.id("password")).sendKeys("Pass35");
		driver.findElement(By.name("Login")).click();
		logger=reports.createTest("Login");
		logger.log(Status.INFO,"Logged Succesfully");
		Assert.assertTrue( driver.findElement(By.xpath("//header[@id='header']/div[1]/div/div/div[2]/div/ul")).getText().contains("Rachana"));
	
	}

	//=======================================================================================================================================
	@Test(priority=3)
	public void testCart() throws InterruptedException
	{

		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.partialLinkText("All Categories"))).perform();
		act1.moveToElement(driver.findElement(By.partialLinkText("Electronics"))).click().perform();
		act1.moveToElement(driver.findElement(By.partialLinkText("Head Phone"))).click().perform();
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
		Assert.assertTrue(driver.findElement(By.className("nomargin")).getText().contains("Headphone"));
		logger=reports.createTest("testCart");
		logger.log(Status.INFO,"headphone is matched");
		driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
		driver.findElement(By.cssSelector("input[value='Proceed to Pay']")).click();
		logger=reports.createTest("Cart success");
		logger.log(Status.INFO,"successful proceed to payment");
		Thread.sleep(4000);

	}

	//==============================================================================================================================================	
	@Test(priority=4)
	public void testPayment() {
		Assert.assertEquals(driver.getTitle(),"Payment Gateway");
		driver.findElement(By.xpath("//label[contains(text(),'Andhra Bank')]")).click();
		driver.findElement(By.id("btn")).click();
		driver.findElement(By.name("username")).sendKeys("123456");
		driver.findElement(By.name("password")).sendKeys("Pass@456");	
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		driver.findElement(By.cssSelector("input[value='PASSWORD']")).sendKeys("Trans@456");
		driver.findElement(By.cssSelector("input[value='PayNow']")).click();
		logger=reports.createTest("Payment");
		logger.log(Status.INFO,"Payment successful");
		Assert.assertTrue(driver.findElement(By.xpath("//div/div/div/div[2]/p")).getText().contains("confirmed"));
		logger=reports.createTest("Order");
		logger.log(Status.INFO,"Order is confirmed");
		driver.findElement(By.linkText("Home")).click();
		Assert.assertTrue(driver.getTitle().contains("Home"));
		driver.findElement(By.linkText("SignOut")).click();
	}
	
	//=============================================================================================================================
	@AfterMethod
	public void getResultAfterMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, "The Test is Failed");
		}
		else if(result.getStatus()==ITestResult.SUCCESS) 
		{
			logger.log(Status.PASS, "The test is passed");
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(Status.SKIP, "The test is skipped");
		}
	}
	
	//======================================================================================================================	
	@AfterTest
	public void endReportAfterTest()
	{
		reports.flush();
		driver.close();
	}
}




