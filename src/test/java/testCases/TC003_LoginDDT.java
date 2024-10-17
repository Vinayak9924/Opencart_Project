package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String exp) {
		logger.info("****Starting TC003_LoginTestDDT");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickmyaccount();
			hp.clickLogin();

			// Login
			LoginPage lp = new LoginPage(driver);
			lp.EnterMailid(email);
			lp.EnterPassword(pwd);
			lp.clkOnLogin();
			// My account
			MyAccountPage macp = new MyAccountPage(driver);
			boolean targetpage = macp.isMyAccountPageExists();
			if (exp.equalsIgnoreCase("Valid")) {
				if (targetpage == true) {
					macp.clkOnLogout();
					Assert.assertTrue(true);

				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetpage == true) {
					macp.clkOnLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("****Finishing TC003_LoginTestDDT");
	}

}
