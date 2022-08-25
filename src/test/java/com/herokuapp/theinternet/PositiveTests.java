package com.herokuapp.theinternet;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class PositiveTests {
    
	@Test
	public void loginTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.tagName("button")).click();
		
		//sleep();
		String expectedurl = "http://the-internet.herokuapp.com/secure";
		String actualurl = driver.getCurrentUrl();
		Assert.assertEquals(expectedurl,actualurl, "URL does not matched ");
		
		WebElement successmessage = driver.findElement(By.xpath("//div[@id='flash']"));
		String expectedmessage = "You logged into a secure area!";
		String actualmessage = successmessage.getText(); 
		Assert.assertTrue(actualmessage.contains(expectedmessage), "Successs is not displayed");
		
		WebElement logoutbutton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logoutbutton.isDisplayed(), "Button displayed");
		
		driver.quit();
		
		
		
      
	}

	
}
