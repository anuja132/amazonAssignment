package assignment_Task3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class amazonUS {

	WebDriver driver;
	@BeforeTest
	public void launchAmazonUSPage()
	{
		System.setProperty("webdriver.gecko.driver", "H:\\Software testing\\driverpath\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}
		@Test(priority = 1) 
		public void searchShoe()
		{
		driver.findElement(By.id("nav-search")).click();
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Shoes");
		driver.findElement(By.id("nav-search-submit-button")).click();
		}
		@Test(priority = 2) 
		public void verifySelectedShoePage()
		{
		String title =  driver.getTitle();
		System.out.println("title is " + title);
		String expected_title = "Amazon.com : Shoes";
		Assert.assertEquals(title, expected_title);
		
			}

	@Test(priority = 3) 
	public void selectShoe()
	{
		driver.findElement(By.linkText("Amazon Essentials Women's Loafer Flat")).click();;
	}
	
	@Test(priority = 4) 
	public void verifyShoeSelection()
	{
		String title2 =  driver.getTitle();
		System.out.println("title2 is " + title2);
		String expected_title2 = "Amazon.com: Amazon Essentials Women's Loafer Flat, Black, 8 B US : Clothing, Shoes & Jewelry";
		Assert.assertEquals(title2, expected_title2);
	}
		@AfterTest
		public void TearDown()
		{
		driver.quit();
		}
	}
	



