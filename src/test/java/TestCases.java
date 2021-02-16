import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases extends SetupConnection {

	@Test(priority = 0, description = "Open Chrome web browser and navigate to https://www.amazon.com/")
	public void validateHomeScreen() {

		String siteUrl = "https://www.amazon.com/";
		driver.get(siteUrl);
		
		String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);		
		
	}
	
	@Test(priority = 1, description = "Proceed with Login and validate the result")
	public void logInHomeScreen() throws InterruptedException {

		//SIMULATE SUCESSFUL LOGIN TO CONTINUE TESTS
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		driver.findElement(By.id("ap_email")).sendKeys("damianpereira.mdq@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("simplilearntest");
		driver.findElement(By.id("signInSubmit")).click();
		
		Thread.sleep(2000);
		
		String validation = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		Assert.assertEquals(validation, "Hello, Damian");
		
	}
	
	@Test(priority = 1, description = "Logout from acccount")
	public void logOutHomeScreen() throws InterruptedException {

		//SIMULATE SUCESSFUL LOGIN TO CONTINUE TESTS
		 WebElement element = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
	     Actions builder = new Actions(driver);
	     builder.moveToElement(element).perform();
	     
	     driver.findElement(By.cssSelector("#nav-item-signout > .nav-text")).click();
	     driver.findElement(By.cssSelector(".a-icon-logo")).click();
		
		Thread.sleep(2000);
		
		String validation = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		Assert.assertEquals(validation, "Hello, Sign in");
		
	}
	
	@Test(priority = 2, description = "Search for 'Xiaomi Redmi 9' and validate result")
	public void searchTest1() throws InterruptedException {

		//SIMULATE SUCESSFUL LOGIN TO CONTINUE TESTS
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("xiaomi redmi 9");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		Thread.sleep(2000);
		
		String validation = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")).getText();
		Assert.assertEquals(validation, "Xiaomi Redmi 9 Unlocked RAM Dual Sim 32GB 3GB RAM 6.53\" International Global Version (Carbon Grey)");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("nav-logo-sprites")).click();
	}
	
	@Test(priority = 2, description = "Search for 'Logitech c922' and validate result")
	public void searchTest2() throws InterruptedException {

		//SIMULATE SUCESSFUL LOGIN TO CONTINUE TESTS
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Logitech c922");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		Thread.sleep(2000);
		
		String validation = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")).getText();
		Assert.assertEquals(validation, "Logitech C922x Pro Stream Webcam – Full 1080p HD Camera");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("nav-logo-sprites")).click();
	}
	
	
	@Test(enabled = false, priority = 1, description = "Test LOGIN with wrong email.")
	public void loginTestWrongEmail() {

		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		driver.findElement(By.id("ap_email")).sendKeys("damianpereira.mdq@gmoil.com");
		driver.findElement(By.id("continue")).click();
		
		String errorMessage = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText();
		Assert.assertEquals(errorMessage, "We cannot find an account with that email address");
		
		System.out.println(errorMessage);

	}

	@Test(enabled = false, priority = 2, description = "Test LOGIN with wrong password")
	public void loginTestWrongPassword() {
		
		driver.findElement(By.id("ap_email")).clear();			
		driver.findElement(By.id("ap_email")).sendKeys("damianpereira.mdq@gmail.com");		
		driver.findElement(By.id("continue")).click();
		
		driver.findElement(By.id("ap_password")).sendKeys("123456789"); 
		driver.findElement(By.id("signInSubmit")).click();
		String errorMessage = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText();
		Assert.assertEquals(errorMessage, "Your password is incorrect");
		
		//System.out.println(errorMessage);		

	}
	
	@Test(enabled = false, priority = 3, description = "Test LOGIN with empty fields")
	public void loginTestEmptyFields() {

		driver.findElement(By.id("ap_password")).clear(); 
		driver.findElement(By.id("ap_password")).sendKeys(""); 
		
		driver.findElement(By.id("signInSubmit")).click();
		
		String errorMessage = driver.findElement(By.xpath("//*[@id=\"auth-password-missing-alert\"]/div/div")).getText();
		Assert.assertEquals(errorMessage, "Enter your password");		

	}
	
	@Test(enabled = false, priority = 4, description = "Test LOGIN with correct email and password")
	public void loginTestCorrectEmailAndPassword() {

		driver.findElement(By.id("ap_password")).clear(); 
		driver.findElement(By.id("ap_password")).sendKeys("simplilearntest"); 
		driver.findElement(By.id("signInSubmit")).click();
		
		//LOGIN CONFIRMATION
		
		System.out.println("Logged succesfuly!");

	}

}
