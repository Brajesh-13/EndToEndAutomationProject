package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstName;
	
	@FindBy(id="input-lastname")
	private WebElement lastName;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telePhoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement privacyPolicybox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continueButton;
	
	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
		
	}
	
	public void selectPrivacyPolicyField() {
		privacyPolicybox.click();
	}
	
	public void enterTextInToFirstNameField(String firstNameText) {
		firstName.sendKeys(firstNameText);
	}

	
	public void enterTextInToLastNameField(String lastNameText) {
		lastName.sendKeys(lastNameText);
		
	}
	
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	public void enterTelephoneNumber(String phoneText) {
		telePhoneField.sendKeys(phoneText);
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String ConfirmPassText) {
		confirmPasswordField.sendKeys(ConfirmPassText);
	}

}
