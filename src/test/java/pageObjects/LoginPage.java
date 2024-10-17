package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@name='email']")
	WebElement TxtMailid;
	@FindBy(xpath = "//*[@id=\"input-password\"]")
	WebElement TxtPasword;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement btnLogin;

	public void EnterMailid(String mail) {
		TxtMailid.sendKeys(mail);
	}

	public void EnterPassword(String pwd) {
		TxtPasword.sendKeys(pwd);
	}

	public void clkOnLogin() {
		btnLogin.click();
	}
}
