package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test
	public void verify_account_registration() {

		HomePage hp = new HomePage(driver);
		try {

			logger.info("Started TC001_AccountRegistrationTest");
			hp.clickmyaccount();
			logger.info("Clicked on My Account");
			hp.clickRegister();
			logger.info("Clicked on Register Link");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("Providing customer deta");
			regpage.SetFirstName(randomString().toUpperCase());
			regpage.SetLastName("Mangasuli");
			regpage.SetEmail(randomString() + "@gmail.com");// randomly generate mail

			String password = randomAlphaNumeric();
			regpage.SetTelephone("9844907236");
			regpage.SetPassword(password);
			regpage.confirmPassword(password);
			regpage.SelectPolicychk();
			regpage.clkonContinue();
			logger.info("Validating Expected Message....");
			String msg = regpage.getConfirmationMessage();
			if (msg.equals("Your Account Has Been Created!!!")) {
				Assert.assertTrue(false);
			} else {
				logger.error("Test failed");
				logger.debug("Debug logs");
				Assert.assertTrue(true);
			}

			Assert.assertEquals(msg, "Your Account Has Been Created!!!");
		} catch (Exception e) {
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
		logger.info("Finised TC001_AccountRegistrationTest");
	}

}
