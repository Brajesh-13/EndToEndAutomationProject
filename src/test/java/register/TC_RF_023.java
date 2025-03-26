package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_023 {
	@Test
	public void verifyRegisterAccountPageNavigation() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.xpath("//i[@class='fa fa-phone']")).click();
		Assert.assertEquals(driver.getTitle(), "Contact Us");
		driver.navigate().back();
		
		driver.findElement(By.xpath("//i[@class='fa fa-heart']")).click();
		Assert.assertEquals(driver.getTitle(), "Account Login");
		driver.navigate().back();
		
		driver.findElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[4]")).click();
		Assert.assertEquals(driver.getTitle(), "Account Login");
		driver.navigate().back();
		
		driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[1]")).click();
		Assert.assertEquals(driver.getTitle(), "Shopping Cart");
		driver.navigate().back();
		
		driver.findElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[5]")).click();
		Assert.assertEquals(driver.getTitle(), "Shopping Cart");
		driver.navigate().back();
		
		driver.findElement(By.xpath("//i[@class='fa fa-share']")).click();
		Assert.assertEquals(driver.getTitle(), "Shopping Cart");
		driver.navigate().back();
		
		driver.findElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[6]")).click();
		Assert.assertEquals(driver.getTitle(), "Shopping Cart");
		driver.navigate().back();
		
		driver.findElement(By.linkText("Qafox.com")).click();
		Assert.assertEquals(driver.getTitle(), "Your Store");
		driver.navigate().back();
		
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		Assert.assertEquals(driver.getTitle(), "Search");
		driver.navigate().back();
		
		driver.findElement(By.xpath("//i[@class='fa fa-home']")).click();
		Assert.assertEquals(driver.getTitle(), "Your Store");
		driver.navigate().back();
		
		driver.quit();
		
		
		
		
		
		
		
	}

}
