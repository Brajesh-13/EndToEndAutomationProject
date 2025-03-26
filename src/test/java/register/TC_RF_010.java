package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_010 {
	@Test
	public void VerifyRegisteringAccountProvideinvalidEmail() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		

		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Brajesh");
		driver.findElement(By.id("input-lastname")).sendKeys("Singh");
		
		//Providing Invalid Email id
		driver.findElement(By.id("input-email")).sendKeys("Brajesh");
		
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("1324");
		driver.findElement(By.id("input-confirm")).sendKeys("1324");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Validation of First type Invalid email
		String ExpectedWarningMessageOne = "Please include an '@' in the email address. 'Brajesh' is missing an '@'.";
		String ActualWarningMessageOne = driver.findElement(By.id("input-email")).getDomProperty("validationMessage");
		Assert.assertEquals(ExpectedWarningMessageOne, ActualWarningMessageOne);
		
		//Validation of Second type Invalid email
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("Brajesh@");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ExpectedWarningMessageTwo = "Please enter a part following '@'. 'Brajesh@' is incomplete.";
		String ActualWarningMessageTwo = driver.findElement(By.id("input-email")).getDomProperty("validationMessage");
		Assert.assertEquals(ActualWarningMessageTwo, ExpectedWarningMessageTwo);
		
		//Validation of Third type Invalid Email 
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("Brajesh@gmail");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ExpectedWarningMessageThird = "E-Mail Address does not appear to be valid!";
		String ActualWarningMessageThird = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
	    Assert.assertEquals(ExpectedWarningMessageThird, ActualWarningMessageThird);
		
		//Validation of Fourth type Invalid Email
	    driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("Brajesh@gmail.");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ExpectedWarningMessageFour = "'.' is used at a wrong position in 'gmail.'.";
		String ActualWarningMessageFour = driver.findElement(By.id("input-email")).getDomProperty("validationMessage");
		Assert.assertEquals(ActualWarningMessageFour, ExpectedWarningMessageFour);
		
		driver.quit();
	}

}
