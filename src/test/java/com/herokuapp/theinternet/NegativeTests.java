package com.herokuapp.theinternet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {
	   
	   @Test
       public void incorrectUsernameTest() {
    	   System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    	   WebDriver driver = new ChromeDriver();
    	   driver.manage().window().maximize();
    	   driver.get("http://the-internet.herokuapp.com/login");
    	   driver.findElement(By.xpath("//input[@id='username']")).sendKeys("skdbasf");
    	   driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
    	   driver.findElement(By.tagName("button")).click();
    	   
    	   WebElement errormessage = driver.findElement(By.id("flash"));
    	   String expectederrormsg = "Your username is invalid!";
    	   String actualerrormsg = errormessage.getText();
    	   Assert.assertTrue(actualerrormsg.contains(expectederrormsg), "No it's not match!!");
    	  
    	          	   
    	  driver.quit();
    	   
       }
	   
	   @Test
       public void incorrectPaswordTest() {
    	   System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    	   WebDriver driver = new ChromeDriver();
    	   driver.manage().window().maximize();
    	   driver.get("http://the-internet.herokuapp.com/login");
    	   driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
    	   driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Incorrectpassword!");
    	   driver.findElement(By.tagName("button")).click();
    	   
    	   WebElement errormessage = driver.findElement(By.id("flash"));
    	   String expectederrormsg = "Your password is invalid!";
    	   String actualerrormsg = errormessage.getText();
    	   Assert.assertTrue(actualerrormsg.contains(expectederrormsg), "No it's not match!!");
        driver.quit();
 }
}
	   
