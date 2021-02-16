import org.openqa.selenium.By;
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
		
		//SIMULATE SUCESSFUL LOGIN TO CONTINUE TESTS
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		driver.findElement(By.id("ap_email")).sendKeys("damianpereira.mdq@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("simplilearntest");
		driver.findElement(By.id("signInSubmit")).click();
		
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
