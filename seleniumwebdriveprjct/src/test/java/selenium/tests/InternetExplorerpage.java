package selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class InternetExplorerpage {
	@Test
	public void internetHomePage()
	{
	System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Java\\selenium\\IEDriverServer.exe");
	WebDriver driver = new InternetExplorerDriver();
	driver.manage().window().maximize();
	driver.get("http://www.google.co.in/");
	//String title=driver.getTitle();
	
	}

}
