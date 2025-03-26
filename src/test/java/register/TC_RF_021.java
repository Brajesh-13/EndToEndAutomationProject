package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Utility;

public class TC_RF_021 {
	@Test
	public void verifyRegisteringAccountWithoutSelectingPrivacyPolicyChcekboxField() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Brajesh");
		driver.findElement(By.id("input-lastname")).sendKeys("Singh");
		
		//Method calling to provide new email id every time 
		driver.findElement(By.id("input-email")).sendKeys(Utility.GenerateNewEmailAddressWithTimeStamp());
		
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String expectedprivacyWarningMessage="Warning: You must agree to the Privacy Policy!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), expectedprivacyWarningMessage);
		driver.quit();
	}
	
	

}
