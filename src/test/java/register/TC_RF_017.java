package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Utility;

public class TC_RF_017 {
	WebDriver driver;
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(dataProvider="passwordSupplier")
	public void verifyRegisteringAccountUsingPasswordWhichAreNotFollowingPasswordComplexityStandard(String passwordText) {
		driver = new ChromeDriver();
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
		driver.findElement(By.id("input-password")).sendKeys(passwordText);
		driver.findElement(By.id("input-confirm")).sendKeys(passwordText);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String expecterdWarning = "Enter password which follows passowrd complexity standard!";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expecterdWarning);
	}
	
	@DataProvider(name="passwordSupplier")
	public Object[][]supplyPassword(){
		Object[][] data = {{"1324"},{"abcdefgghi"},{"abcd1234"},{"abcd123#$"},{"WDFGA&*3"}};
		return data;
		
	}

}
