package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.Utility;

public class TC_RF_019 {
	WebDriver driver;
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@Test
	public void verfiyRegisterAccountUsingLaedingAndTrailingSpaces() {
		SoftAssert softassert = new SoftAssert();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		String firstname="  Brajesh  ";
		driver.findElement(By.id("input-firstname")).sendKeys(firstname);
		String lastname = "  Singh  ";
		driver.findElement(By.id("input-lastname")).sendKeys(lastname);
		
		//Method calling to provide new email id every time 
		String emailText = "  "+Utility.GenerateNewEmailAddressWithTimeStamp()+"  ";
		driver.findElement(By.id("input-email")).sendKeys(emailText);
		
		String telephone="  1234567890  ";
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
		driver.findElement(By.id("input-password")).sendKeys("  12345  ");
		driver.findElement(By.id("input-confirm")).sendKeys("  12345  ");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//a[@class='btn btn-primary'][text()='Continue']")).click();
		driver.findElement(By.linkText("Edit your account information")).click();
		
		softassert.assertEquals(driver.findElement(By.id("input-firstname")).getDomAttribute("value"),firstname.trim());
		softassert.assertEquals(driver.findElement(By.id("input-lastname")).getDomAttribute("value"), lastname.trim());
		softassert.assertEquals(driver.findElement(By.id("input-email")).getDomAttribute("value"), emailText.trim());
		softassert.assertEquals(driver.findElement(By.id("input-telephone")).getDomAttribute("value"), telephone.trim());
		softassert.assertAll();
		
	}

}
