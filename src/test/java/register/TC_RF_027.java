package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Utility;

public class TC_RF_027 {
	@Test(dataProvider="supplyTestEnvironments")
	public void verifyRegisterAccountInAllEnvironment(String browserName) {
		
		WebDriver driver = null;
		
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
			
		}else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
			
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
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
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		driver.quit();
		
		
		
	}
	
	@DataProvider(name="supplyTestEnvironments")
		public Object[][] supplyenvironment() {
		Object[][] envs ={{"chrome"},{"edge"},{"firefox"}};
		return envs;	
		}

}
