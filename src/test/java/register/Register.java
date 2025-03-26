package register;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HeaderOptions;
import utils.Utility;

public class Register {
	
	WebDriver driver;
	String browserName;
	Properties prop;
	
	@AfterMethod
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	@BeforeMethod
	public void setup() {
		prop = Utility.loadpropertiesFile();
		browserName = prop.getProperty("browserName");
		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equals("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(prop.getProperty("appurl"));
		
		HeaderOptions headeroptions = new HeaderOptions(driver);
		headeroptions.clickOnMyAccountMenu();
		headeroptions.clickOnRegisterButton();
	
		
	}
	
	@Test(priority=1)
	public void VerifyRegisteringAccountUsingMandatoryFields() {
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		
		//Method calling to provide new email id every time 
		driver.findElement(By.id("input-email")).sendKeys(Utility.GenerateNewEmailAddressWithTimeStamp());
		
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
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
		 

	}
	@Test(priority=2)
	public void VerifyRegisteringAccountWithAllFields() {
		
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		
		//Method calling to provide new email id every time 
		driver.findElement(By.id("input-email")).sendKeys(Utility.GenerateNewEmailAddressWithTimeStamp());
		
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
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
		 
		

}
	@Test(priority=3)
public void VerifyWarningMessageOfMandatoryFieldsInRegisterAccountPage() {
		
		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(),expectedFirstNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), expectedLastNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(), expectedEmailWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), expectedTelephoneWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expectedPasswordWarning);
		
		
	}
	@Test(priority=4)
	public void VerifyRegisteringAccountBySubscribingTheNewsletter() {
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		
		//Method calling to provide new email id every time 
		driver.findElement(By.id("input-email")).sendKeys(Utility.GenerateNewEmailAddressWithTimeStamp());
		
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		
		driver.findElement(By.xpath("//input[@name='newsletter'][@Value='1']")).click();
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']/child::li/child::a[text()='Newsletter']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@Value='1']")).isSelected());
		
	   
	}
	@Test(priority=5)
	public void VerifyRegisteringAccountByNOTSubscribingTheNewsletter() {
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		
		//Method calling to provide new email id every time 
		driver.findElement(By.id("input-email")).sendKeys(Utility.GenerateNewEmailAddressWithTimeStamp());
		
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).click();
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']/child::li/child::a[text()='Newsletter']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']")).isSelected());
		
	  

	}
	@Test(priority=6)
	public void VerifyDifferentWayOfNavigatingRegisterAccountPage() {
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
		
		//Second Way 
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li[2]//a")).click();
		driver.findElement(By.linkText("Continue")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
		
		//Third Way 
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li[2]//a")).click();
		driver.findElement(By.xpath("//div[@class='list-group']//a[2]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
		
		
	}
	@Test(priority=7)
public void VerifyRegisteringAccountProvidingMismatchPassword() {
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		
		//Method calling to provide new email id every time 
		driver.findElement(By.id("input-email")).sendKeys(Utility.GenerateNewEmailAddressWithTimeStamp());
		
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("mismatchPassword"));
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ExpectedWarnig = "Password confirmation does not match password!";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div")).getText(), ExpectedWarnig);
		


	}
	@Test(priority=8)
public void VerifyRegisterAccountProvidingExistingMailAddress() {
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		
		//Providing Existing Email id 
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("existingEmail"));
		
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ExpectedWarning = "Warning: E-Mail Address is already registered!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),ExpectedWarning);
	
		
	
	}
	@Test(priority=9)
	public void VerifyRegisteringAccountProvideinvalidEmail() throws InterruptedException {
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		
		//Providing Invalid Email id
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("invalidEmailOne"));
		
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Validation of First type Invalid email
		String ExpectedWarningMessageOne = "Please include an '@' in the email address. 'Brajesh' is missing an '@'.";
		String ActualWarningMessageOne = driver.findElement(By.id("input-email")).getDomProperty("validationMessage");
		Assert.assertEquals(ExpectedWarningMessageOne, ActualWarningMessageOne);
		
		//Validation of Second type Invalid email
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("invalidEmailTwo"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ExpectedWarningMessageTwo = "Please enter a part following '@'. 'Brajesh@' is incomplete.";
		String ActualWarningMessageTwo = driver.findElement(By.id("input-email")).getDomProperty("validationMessage");
		Assert.assertEquals(ActualWarningMessageTwo, ExpectedWarningMessageTwo);
		
		//Validation of Third type Invalid Email 
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("invalidEmailThree"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ExpectedWarningMessageThird = "E-Mail Address does not appear to be valid!";
		String ActualWarningMessageThird = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
	    Assert.assertEquals(ExpectedWarningMessageThird, ActualWarningMessageThird);
		
		//Validation of Fourth type Invalid Email
	    driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmailFour"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String ExpectedWarningMessageFour = "'.' is used at a wrong position in 'gmail.'.";
		String ActualWarningMessageFour = driver.findElement(By.id("input-email")).getDomProperty("validationMessage");
		Assert.assertEquals(ActualWarningMessageFour, ExpectedWarningMessageFour);
		
		
	}

	@Test(priority=10)
public void VerifyRegisteringAccountProvidingInvalidPhoneNumber() {
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		
		//Providing unique Email id
		driver.findElement(By.id("input-email")).sendKeys(Utility.GenerateNewEmailAddressWithTimeStamp());
		
		//Providing Invalid phone number 
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("invalidPhoneNumber"));
		
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String expectedWarningMessage = "The Telephone number entered by you is invalid";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),expectedWarningMessage);
		
		Assert.assertFalse(driver.findElement(By.linkText("Success")).isDisplayed());
		
	}
	@Test(priority=11)
	public void verifyRegisteringAccountUsingKeyboardKeys() {	
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).pause(Duration.ofSeconds(2))
		.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).sendKeys(Keys.ENTER)
		.build().perform();
		
		for(int i=1;i<=23;i++) {
			actions.sendKeys(Keys.TAB).perform();
		}
		
		actions.sendKeys(prop.getProperty("firstName")).sendKeys(Keys.TAB).sendKeys(prop.getProperty("lastName")).sendKeys(Keys.TAB).sendKeys(Utility.GenerateNewEmailAddressWithTimeStamp())
		.sendKeys(Keys.TAB).sendKeys(prop.getProperty("telephoneNumber")).sendKeys(Keys.TAB).sendKeys(prop.getProperty("validPassword")).sendKeys(Keys.TAB)
		.sendKeys(prop.getProperty("validPassword")).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
		.sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform(); 
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//child::li[3]")).isDisplayed());
		}
	
	@Test(priority=12)
public void verifyRegisterAccountPagePlaceHolder() {
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
		
	}
@Test(priority=13)
	public void verifyMandatoryFieldsInRegisterAccountPage() {
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
		
	}

@Test(priority=14)
public void verifyRegisteringAccountByEnteringOnlySpaces() {
	driver.findElement(By.id("input-firstname")).sendKeys("    ");
	driver.findElement(By.id("input-lastname")).sendKeys("    ");
	
	//Method calling to provide new email id every time 
	driver.findElement(By.id("input-email")).sendKeys("    ");
	
	driver.findElement(By.id("input-telephone")).sendKeys("    ");
	driver.findElement(By.id("input-password")).sendKeys("    ");
	driver.findElement(By.id("input-confirm")).sendKeys("    ");
	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
	String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
	String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
	String expectedTelephoneWarning = "Telephone does not appear to be valid!";
	
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), expectedFirstNameWarning);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")), expectedLastNameWarning);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")), expectedEmailWarning);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")), expectedTelephoneWarning);
}
@Test(priority=15)
public void verifyRegisteringAccountUsingPasswordWhichAreNotFollowingPasswordComplexityStandard(String passwordText) {
	driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
	driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
	
	//Method calling to provide new email id every time 
	driver.findElement(By.id("input-email")).sendKeys(Utility.GenerateNewEmailAddressWithTimeStamp());
	
	driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
	driver.findElement(By.id("input-password")).sendKeys(passwordText);
	driver.findElement(By.id("input-confirm")).sendKeys(passwordText);
	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	String expecterdWarning = "Enter password which follows passowrd complexity standard!";
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), expecterdWarning);
}

@DataProvider(name="passwordSupplier")
public Object[][]supplyPassword(){
	Object[][] data = {{"1324"},{"abcdefgghi"},{"abcd1234"},{"abcd123#$"},{"WDFGA&*3"}};
	return data;
	
}
@Test(priority=16)
public void verfiyRegisterAccountUsingLaedingAndTrailingSpaces() {
	SoftAssert softassert = new SoftAssert();
	String firstname="  "+prop.getProperty("firstName")+"  ";
	driver.findElement(By.id("input-firstname")).sendKeys(firstname);
	String lastname = "  "+prop.getProperty("lastName")+"  ";
	driver.findElement(By.id("input-lastname")).sendKeys(lastname);
	
	//Method calling to provide new email id every time 
	String emailText = "  "+Utility.GenerateNewEmailAddressWithTimeStamp()+"  ";
	driver.findElement(By.id("input-email")).sendKeys(emailText);
	
	String telephone="  "+prop.getProperty("telephoneNumber")+"  ";
	driver.findElement(By.id("input-telephone")).sendKeys(telephone);
	driver.findElement(By.id("input-password")).sendKeys("  "+prop.getProperty("validPassword")+"  ");
	driver.findElement(By.id("input-confirm")).sendKeys("  "+prop.getProperty("validPassword")+"  ");
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
@Test(priority=17)
public void verifyRegisterAccountPrivacyPolicyField() {
	//Verify privacy policy field is not selected
	Assert.assertFalse(driver.findElement(By.xpath("//input[@name='agree']")).isSelected());
}
@Test(priority=18)
public void verifyRegisteringAccountWithoutSelectingPrivacyPolicyChcekboxField() {
	driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
	driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
	
	//Method calling to provide new email id every time 
	driver.findElement(By.id("input-email")).sendKeys(Utility.GenerateNewEmailAddressWithTimeStamp());
	
	driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
	driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
	driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	String expectedprivacyWarningMessage="Warning: You must agree to the Privacy Policy!";
	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), expectedprivacyWarningMessage);
}
@Test(priority=19)
public void verifyRegisteringAccountPasswordFieldsForSecurity() {
	//Verifying password security
	Assert.assertEquals(driver.findElement(By.id("input-password")).getDomAttribute("type"), "password");
	Assert.assertEquals(driver.findElement(By.id("input-confirm")).getDomAttribute("type"), "password");
	
}
@Test(priority=20)
public void verifyRegisterAccountPageNavigation() {
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
}
@Test(priority=21)
public void verifyRegisteringAccountWithoutEnteringConfirmPassword() {	
	driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
	driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
	
	//Method calling to provide new email id every time 
	driver.findElement(By.id("input-email")).sendKeys(Utility.GenerateNewEmailAddressWithTimeStamp());
	
	driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
	driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	String expectedWarningMessage="Password confirmation does not match password!";
	Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div")).getText(), expectedWarningMessage);
	
}

@Test(priority=22)
public void verifyRegisterAccountPageBreadCrumbURLTitleHeading() {
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
}

@Test(priority=23)
public void verifyRegisterAccountUI() throws IOException {
	//Calling Take screenshot & compare screenshot method 
	//expected screenshot i already taken using name expectedRegPageUI name & now Comparing
	Utility.takeScreenshot(driver, System.getProperty("user.dir")+"\\Screenshots\\actualRegPageUI.png");
	Utility.compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\expectedRegPageUI.png", System.getProperty("user.dir")+"\\Screenshots\\actualRegPageUI.png");
	
}

@Test(priority=24)
public void verifyRegisterAccountInAllEnvironment() {
	
	
	driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
	driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
	
	//Method calling to provide new email id every time 
	driver.findElement(By.id("input-email")).sendKeys(Utility.GenerateNewEmailAddressWithTimeStamp());
	
	driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
	driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
	driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Logout']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
	
	
}

@DataProvider(name="supplyTestEnvironments")
	public Object[][] supplyenvironment() {
	Object[][] envs ={{"chrome"},{"edge"},{"firefox"}};
	return envs;	
	}



}
