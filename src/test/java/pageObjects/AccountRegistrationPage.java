package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement TxtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement TxtLastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement TxtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement TxtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement TxtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement TxtConfirmPassword;

	@FindBy(xpath = "//label[normalize-space()='Yes']//input[@name='newsletter']")
	WebElement SelectSubscribe;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkdPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void SetFirstName(String fname) {
		TxtFirstname.sendKeys(fname);
	}

	public void SetLastName(String lname) {
		TxtLastname.sendKeys(lname);
	}

	public void SetEmail(String mailid) {
		TxtEmail.sendKeys(mailid);
	}

	public void SetTelephone(String Telephone) {
		TxtTelephone.sendKeys(Telephone);
	}

	public void SetPassword(String password) {
		TxtPassword.sendKeys(password);
	}

	public void confirmPassword(String password) {
		TxtConfirmPassword.sendKeys(password);
	}

	public void SelectSubscribeOptions() {
		SelectSubscribe.click();
	}

	public void SelectPolicychk() {
		chkdPolicy.click();
	}

	public void clkonContinue() {
		btnContinue.click();
	}

	public String getConfirmationMessage() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {

			return (e.getMessage());
		}

	}
}
