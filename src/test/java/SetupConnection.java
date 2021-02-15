import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class SetupConnection {
	
	WebDriver  driver;
	
	@BeforeMethod
	public void setUpDriver() throws Exception {
		// 1. set Selenium properties
		System.setProperty("webdriver.chrome.driver", "WebDrivers/chromedriver.exe");
		
		// 2. Instantiating Selenium web driver		
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}
	
	

	
	

}
