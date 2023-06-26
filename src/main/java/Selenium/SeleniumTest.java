package Selenium;

 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	
WebDriver driver;

@BeforeTest

public void setUp()  
{
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(options);
}

@Test
public void login()
{
	driver.get("https://demo.guru99.com/v4/");
	driver.findElement(By.name("uid")).sendKeys("mngr511671");
	driver.findElement(By.name("password")).sendKeys("suryran");
	driver.findElement(By.name("btnLogin")).click();
}

@AfterTest
public void tearDown()
{
	driver.close();
	driver.quit();
}
}
