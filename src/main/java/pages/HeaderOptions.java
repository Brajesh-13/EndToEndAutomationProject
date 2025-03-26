package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderOptions {
	WebDriver driver;
	
	public HeaderOptions(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Register")
	private WebElement registerbutton;
	
	public void clickOnMyAccountMenu() {
		myAccountDropMenu.click();
	}
	
	public void clickOnRegisterButton() {
		registerbutton.click();
	}

}
