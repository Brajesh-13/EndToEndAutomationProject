package register;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utils.Utility;

public class TC_RF_026 {

	@Test
	public void verifyRegisterAccountUI() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		//Calling Take screenshot & compare screenshot method 
		//expected screenshot i already taken using name expectedRegPageUI name & now Comparing
		Utility.takeScreenshot(driver, System.getProperty("user.dir")+"\\Screenshots\\actualRegPageUI.png");
		Utility.compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\expectedRegPageUI.png", System.getProperty("user.dir")+"\\Screenshots\\actualRegPageUI.png");
		driver.quit();
	}
	
}
