package Selenium;

 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	
WebDriver driver;
SoftAssert sa;

@BeforeTest

public void setUp()  
{
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(options);
	sa = new SoftAssert();
}

@Test (priority = 1)
public void login()
{
	driver.get("https://demo.guru99.com/v4/");
	driver.findElement(By.name("uid")).sendKeys("mngr511671");
	driver.findElement(By.name("password")).sendKeys("suryran");
	driver.findElement(By.name("btnLogin")).click();
	sa.assertEquals(driver.findElement(By.xpath("//tr[@class='heading3']/td")).getText(), "Manger Id : mngr511671"); //validate login
}

@Test (priority = 2)
public void invalid_login()
{
	driver.get("https://demo.guru99.com/v4/");
	driver.findElement(By.name("uid")).sendKeys("mngr511671");
	driver.findElement(By.name("password")).sendKeys("suryrann");  //invalid password
	driver.findElement(By.name("btnLogin")).click();
	sa.assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");

}
@AfterTest
public void tearDown()
{
	sa.assertAll();
	driver.quit();
}
}
