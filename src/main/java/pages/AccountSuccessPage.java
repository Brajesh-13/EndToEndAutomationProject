package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	
WebDriver driver;

public AccountSuccessPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//a[@class='list-group-item'][text()='Logout']")
private WebElement logoutOption;

@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Success']")
private WebElement accountSuccessPageBreadcrum;

@FindBy(id="content")
private WebElement accountSuccessPageContent;

@FindBy(linkText="Continue")
private WebElement continuebtn;

public MyAccountPage clickOnContinueButton() {
	continuebtn.click();
	return new MyAccountPage(driver);
}

public String getContentAccountSuccessPage() {
	return accountSuccessPageContent.getText();
}

public boolean didWeNavigateToAccountSuccessPage() {
	return accountSuccessPageBreadcrum.isDisplayed();
}

public boolean isUserLoggedIn() {
	return logoutOption.isDisplayed();
}

}
