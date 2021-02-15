import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases extends SetupConnection {

	@Test
	public void test1() {

		String siteUrl = "https://www.amazon.com/";
		driver.get(siteUrl);
		String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		
		System.out.println(actualTitle);
		

	}

	@Test
	public void test2() {

		String siteUrl = "https://www.amazon.in/";
		driver.get(siteUrl);
		String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		
		System.out.println("This is the TEST 2 result.");
		System.out.println(actualTitle);

	}
	
	@Test
	public void test3() {

		System.out.println("This is the TEST 3 result.");

	}

}
