package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_013 {
	@Test
	public void verifyRegisterAccountPagePlaceHolder() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String ExpectedFirstNamePlaceHolder = "First Name";
		String ExpectedLastNamePlaceHolder  = "Last Name";
		String ExpectedEmailPlaceHolder = "E-Mail";
		String ExpectedTelephonePlaceHolder = "Telephone";
		String ExpectedPasswordPlaceHolder = "Password";
		String ExpectedConfirmPasswordPlaceHolder = "Password Confirm";
		
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getDomProperty("placeholder"), ExpectedFirstNamePlaceHolder);
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getDomProperty("placeholder"), ExpectedLastNamePlaceHolder);
		Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("placeholder"), ExpectedEmailPlaceHolder);
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getDomProperty("placeholder"), ExpectedTelephonePlaceHolder);
		Assert.assertEquals(driver.findElement(By.id("input-password")).getDomProperty("placeholder"), ExpectedPasswordPlaceHolder);
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getDomProperty("placeholder"), ExpectedConfirmPasswordPlaceHolder);
		
		driver.quit();
		
		
		
	}

}
