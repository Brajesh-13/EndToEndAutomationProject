package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_022 {
	@Test
	public void verifyRegisteringAccountPasswordFieldsForSecurity() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		//Verifying password security
		Assert.assertEquals(driver.findElement(By.id("input-password")).getDomAttribute("type"), "password");
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getDomAttribute("type"), "password");
		driver.quit();
		
	}

}
