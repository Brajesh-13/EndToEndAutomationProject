package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_025 {
	@Test
	public void verifyRegisterAccountPageBreadCrumbURLTitleHeading() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		//Verify Current Title
		String expectedTitle="Register Account";
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		
		//Verify Current URL 
		String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/register";
		Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
		
		//Verify BreadCrumb
		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());
		
		//Verify Heading
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), "Register Account");
		
		driver.quit();
	}

}
