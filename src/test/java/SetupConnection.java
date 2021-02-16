import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class SetupConnection {
	
	static WebDriver driver;
	
	@BeforeTest
	public void setUpDriver() throws Exception {
		// 1. set Selenium properties
		System.setProperty("webdriver.chrome.driver", "WebDrivers/chromedriver.exe");
		
		// 2. Instantiating Selenium web driver		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.close();
	}
}
