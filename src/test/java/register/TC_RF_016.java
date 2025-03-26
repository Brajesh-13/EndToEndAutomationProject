package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_RF_016 {
	
	WebDriver driver;
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@Test
	public void verifyRegisteringAccountByEnteringOnlySpaces() {
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("    ");
		driver.findElement(By.id("input-lastname")).sendKeys("    ");
		
		//Method calling to provide new email id every time 
		driver.findElement(By.id("input-email")).sendKeys("    ");
		
		driver.findElement(By.id("input-telephone")).sendKeys("    ");
		driver.findElement(By.id("input-password")).sendKeys("    ");
		driver.findElement(By.id("input-confirm")).sendKeys("    ");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedTelephoneWarning = "Telephone does not appear to be valid!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), expectedFirstNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")), expectedLastNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")), expectedEmailWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")), expectedTelephoneWarning);
	}

}
