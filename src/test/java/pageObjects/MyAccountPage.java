package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement MsgHeading;

	@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[13]")
	WebElement lnkLogout;

	public boolean isMyAccountPageExists() {

		try {
			return (MsgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}

	}

	public void clkOnLogout() {
		lnkLogout.click();
	}

}