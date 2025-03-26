package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_RF_014 {
	WebDriver driver;
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void verifyMandatoryFieldsInRegisterAccountPage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";
		WebElement firstNameLabel = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		WebElement lastNameLabel = driver.findElement(By.cssSelector("label[for='input-lastname'"));
		WebElement emailLabel = driver.findElement(By.cssSelector("label[for='input-email'"));
		WebElement telephoneLabel = driver.findElement(By.cssSelector("label[for='input-telephone'"));
		WebElement passwordLabel = driver.findElement(By.cssSelector("label[for='input-password'"));
		WebElement confirmPasswordLabel = driver.findElement(By.cssSelector("label[for='input-confirm'"));
		WebElement privacyPolicyLabel = driver.findElement(By.cssSelector("div[class='pull-right']"));
		
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String firstNameLabelContent=(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", firstNameLabel);
		Assert.assertEquals(firstNameLabelContent, expectedContent);
        String firstNameLabelColor=(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", firstNameLabel);
		Assert.assertEquals(firstNameLabelColor, expectedColor);
		
		String lastNameLabelContent=(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", lastNameLabel);
		Assert.assertEquals(lastNameLabelContent, expectedContent);
        String lastNameLabelColor=(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", lastNameLabel);
		Assert.assertEquals(lastNameLabelColor, expectedColor);
		
		String emailLabelContent=(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", emailLabel);
		Assert.assertEquals(emailLabelContent, expectedContent);
        String emailLabelColor=(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", emailLabel);
		Assert.assertEquals(emailLabelColor, expectedColor);
		
		String telephoneLabelContent=(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", telephoneLabel);
		Assert.assertEquals(telephoneLabelContent, expectedContent);
        String telephoneLabelColor=(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", telephoneLabel);
		Assert.assertEquals(telephoneLabelColor, expectedColor);
		
		String passwordLabelContent=(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", passwordLabel);
		Assert.assertEquals(passwordLabelContent, expectedContent);
        String passwordLabelColor=(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", passwordLabel);
		Assert.assertEquals(passwordLabelColor, expectedColor);
		
		String confirmPasswordLabelContent=(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", confirmPasswordLabel);
		Assert.assertEquals(confirmPasswordLabelContent, expectedContent);
        String confirmPasswordLabelColor=(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", confirmPasswordLabel);
		Assert.assertEquals(confirmPasswordLabelColor, expectedColor);
		
		String privacyPolicyLabelContent=(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('content');", privacyPolicyLabel);
		Assert.assertEquals(privacyPolicyLabelContent, expectedContent);
        String privacyPolicyLabelColor=(String)jse.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color');", privacyPolicyLabel);
		Assert.assertEquals(privacyPolicyLabelColor, expectedColor);
		
		
		
		
		driver.quit();
		
		
	}

}
