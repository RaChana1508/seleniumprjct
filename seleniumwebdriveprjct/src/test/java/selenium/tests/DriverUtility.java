package selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//java doc
/**
 * 
 * @author Rachana.biyyapu
 *
 */
public class DriverUtility {
	static public WebDriver getDriver(String browser)
	{
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\selenium\\chromedriver.exe");
			return new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\selenium\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Java\\selenium\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		else
		{
			return null;
		}
	}

}
