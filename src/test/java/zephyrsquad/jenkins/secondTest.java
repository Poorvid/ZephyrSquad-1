package zephyrsquad.jenkins;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class secondTest {

	WebDriver driver;

	@BeforeTest
	public void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void secondtest() {

		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("Harry");
		driver.findElement(By.id("password")).sendKeys("Potter");
		driver.findElement(By.id("login-button")).click();
		
		
		String actual=driver.getCurrentUrl();
		System.out.println(actual);
		
		//String expected="https://www.saucedemo.com/";
		String expected="https://www.saucedemo.com/inventory.html";
		assertEquals(actual, expected, "testcase failed");
			
	}
	
	@Test(dependsOnMethods = { "secondtest" })
	public void testing()
	{
		System.out.println("Lets see if this statement prints");
	}

	@AfterTest
	public void end() {

		driver.close();
	}

}

































