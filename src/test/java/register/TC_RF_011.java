package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import utils.Utility;

public class TC_RF_011 {
	
	WebDriver driver; 
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
	@Test
	public void VerifyRegisteringAccountProvidingInvalidPhoneNumber() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		

		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Brajesh");
		driver.findElement(By.id("input-lastname")).sendKeys("Singh");
		
		//Providing unique Email id
		driver.findElement(By.id("input-email")).sendKeys(Utility.GenerateNewEmailAddressWithTimeStamp());
		
		//Providing Invalid phone number 
		driver.findElement(By.id("input-telephone")).sendKeys("abcde");
		
		driver.findElement(By.id("input-password")).sendKeys("1324");
		driver.findElement(By.id("input-confirm")).sendKeys("1324");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String expectedWarningMessage = "The Telephone number entered by you is invalid";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),expectedWarningMessage);
		
		Assert.assertFalse(driver.findElement(By.linkText("Success")).isDisplayed());
		
	
		
	}

}
