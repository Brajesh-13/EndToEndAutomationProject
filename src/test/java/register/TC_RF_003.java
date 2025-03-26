package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Utility;

public class TC_RF_003 {
	
	@Test
	public void VerifyRegisteringAccountWithAllFields() {
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
		driver.findElement(By.id("input-password")).sendKeys("1324");
		driver.findElement(By.id("input-confirm")).sendKeys("1324");
		driver.findElement(By.xpath("//div[@class='form-group']/child::div/child::label[1]")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		
		
		String Properdetailone = "Your Account Has Been Created!";
		String Properdetailtwo = "Congratulations! Your new account has been successfully created!";
	    String Properdetailsthree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String Properdetailfour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String Properdetailfive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us";
		
		
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(Properdetailone));
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(Properdetailtwo));
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(Properdetailsthree));
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(Properdetailfour));
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(Properdetailfive));
		
		driver.findElement(By.linkText("Continue")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		 
		driver.quit();

}
}
